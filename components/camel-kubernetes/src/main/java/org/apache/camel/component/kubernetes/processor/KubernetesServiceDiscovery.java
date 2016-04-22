/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.kubernetes.processor;

import java.util.ArrayList;
import java.util.List;

import io.fabric8.kubernetes.api.model.EndpointAddress;
import io.fabric8.kubernetes.api.model.EndpointPort;
import io.fabric8.kubernetes.api.model.EndpointSubset;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.camel.support.ServiceSupport;
import org.apache.camel.util.IOHelper;
import org.apache.camel.util.ObjectHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KubernetesServiceDiscovery extends ServiceSupport {

    private static final Logger LOG = LoggerFactory.getLogger(KubernetesServiceDiscovery.class);
    private static final int FIRST = 0;

    private String name;
    private String namespace;
    private String portName;
    private KubernetesClient client;

    public KubernetesServiceDiscovery(String name, String namespace, String portName, KubernetesClient client) {
        this.name = name;
        this.namespace = namespace;
        this.portName = portName;
        this.client = client;
    }

    public List<Server> getUpdatedListOfServers() {
        Endpoints endpoints = client.endpoints().inNamespace(namespace).withName(name).get();
        List<Server> result = new ArrayList<Server>();
        if (endpoints != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Found [" + endpoints.getSubsets().size() + "] endpoints in namespace [" +
                        namespace + "] for name [" + name + "] and portName [" + portName + "]");
            }
            for (EndpointSubset subset : endpoints.getSubsets()) {
                if (subset.getPorts().size() == 1) {
                    EndpointPort port = subset.getPorts().get(FIRST);
                    for (EndpointAddress address : subset.getAddresses()) {
                        result.add(new Server(address.getIp(), port.getPort()));
                    }
                } else {
                    for (EndpointPort port : subset.getPorts()) {
                        if (ObjectHelper.isEmpty(portName) || portName.endsWith(port.getName())) {
                            for (EndpointAddress address : subset.getAddresses()) {
                                result.add(new Server(address.getIp(), port.getPort()));
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    @Override
    protected void doStart() throws Exception {
        // noop
    }

    @Override
    protected void doStop() throws Exception {
        if (client != null) {
            IOHelper.close(client);
        }
    }
}
