/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.camel.spi.Metadata;

@Metadata(label = "eip,routing")
@XmlRootElement(name = "toServiceConfiguration")
@XmlAccessorType(XmlAccessType.FIELD)
public class ToServiceConfigurationDefinition extends IdentifiedType {

    @XmlTransient
    private ToServiceDefinition parent;
    @XmlAttribute @Metadata(required = "true")
    private String masterUrl;
    @XmlAttribute
    private String namespace;
    @XmlAttribute
    private String apiVersion;
    @XmlAttribute @Metadata(label = "security")
    private String username;
    @XmlAttribute @Metadata(label = "security")
    private String password;
    @XmlAttribute @Metadata(label = "security")
    private String oauthToken;
    @XmlAttribute @Metadata(label = "security")
    private String caCertData;
    @XmlAttribute @Metadata(label = "security")
    private String caCertFile;
    @XmlAttribute @Metadata(label = "security")
    private String clientCertData;
    @XmlAttribute @Metadata(label = "security")
    private String clientCertFile;
    @XmlAttribute @Metadata(label = "security")
    private String clientKeyAlgo;
    @XmlAttribute @Metadata(label = "security")
    private String clientKeyData;
    @XmlAttribute @Metadata(label = "security")
    private String clientKeyFile;
    @XmlAttribute @Metadata(label = "security")
    private String clientKeyPassphrase;
    @XmlAttribute @Metadata(label = "security")
    private Boolean trustCerts;

    public ToServiceConfigurationDefinition() {
    }

    public ToServiceConfigurationDefinition(ToServiceDefinition parent) {
        this.parent = parent;
    }

    // Getter/Setter
    // -------------------------------------------------------------------------

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaCertData() {
        return caCertData;
    }

    public void setCaCertData(String caCertData) {
        this.caCertData = caCertData;
    }

    public String getCaCertFile() {
        return caCertFile;
    }

    public void setCaCertFile(String caCertFile) {
        this.caCertFile = caCertFile;
    }

    public String getClientCertData() {
        return clientCertData;
    }

    public void setClientCertData(String clientCertData) {
        this.clientCertData = clientCertData;
    }

    public String getClientCertFile() {
        return clientCertFile;
    }

    public void setClientCertFile(String clientCertFile) {
        this.clientCertFile = clientCertFile;
    }

    public String getClientKeyAlgo() {
        return clientKeyAlgo;
    }

    public void setClientKeyAlgo(String clientKeyAlgo) {
        this.clientKeyAlgo = clientKeyAlgo;
    }

    public String getClientKeyData() {
        return clientKeyData;
    }

    public void setClientKeyData(String clientKeyData) {
        this.clientKeyData = clientKeyData;
    }

    public String getClientKeyFile() {
        return clientKeyFile;
    }

    public void setClientKeyFile(String clientKeyFile) {
        this.clientKeyFile = clientKeyFile;
    }

    public String getClientKeyPassphrase() {
        return clientKeyPassphrase;
    }

    public void setClientKeyPassphrase(String clientKeyPassphrase) {
        this.clientKeyPassphrase = clientKeyPassphrase;
    }

    public String getOauthToken() {
        return oauthToken;
    }

    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    public Boolean getTrustCerts() {
        return trustCerts;
    }

    public void setTrustCerts(Boolean trustCerts) {
        this.trustCerts = trustCerts;
    }


    // Fluent API
    // -------------------------------------------------------------------------

    /**
     * Sets the URL to the master
     */
    public ToServiceConfigurationDefinition masterUrl(String masterUrl) {
        setMasterUrl(masterUrl);
        return this;
    }

    /**
     * Sets the namespace to use
     */
    public ToServiceConfigurationDefinition namespace(String namespace) {
        setNamespace(namespace);
        return this;
    }

    /**
     * Sets the API version
     */
    public ToServiceConfigurationDefinition apiVersion(String apiVersion) {
        setApiVersion(apiVersion);
        return this;
    }

    /**
     * Sets the username for authentication
     */
    public ToServiceConfigurationDefinition username(String username) {
        setUsername(username);
        return this;
    }

    /**
     * Sets the password for authentication
     */
    public ToServiceConfigurationDefinition password(String password) {
        setPassword(password);
        return this;
    }

    /**
     * Sets the OAUTH token for authentication (instead of username/password)
     */
    public ToServiceConfigurationDefinition oauthToken(String oauthToken) {
        setOauthToken(oauthToken);
        return this;
    }

    /**
     * Sets the Certificate Authority data
     */
    public ToServiceConfigurationDefinition caCertData(String caCertData) {
        setCaCertData(caCertData);
        return this;
    }

    /**
     * Sets the Certificate Authority data that are loaded from the file
     */
    public ToServiceConfigurationDefinition caCertFile(String caCertFile) {
        setCaCertFile(caCertFile);
        return this;
    }

    /**
     * Sets the Client Certificate data
     */
    public ToServiceConfigurationDefinition clientCertData(String clientCertData) {
        setClientCertData(clientCertData);
        return this;
    }

    /**
     * Sets the Client Certificate data that are loaded from the file
     */
    public ToServiceConfigurationDefinition clientCertFile(String clientCertFile) {
        setClientCertFile(clientCertFile);
        return this;
    }

    /**
     * Sets the Client Keystore algorithm, such as RSA.
     */
    public ToServiceConfigurationDefinition clientKeyAlgo(String clientKeyAlgo) {
        setClientKeyAlgo(clientKeyAlgo);
        return this;
    }

    /**
     * Sets the Client Keystore data
     */
    public ToServiceConfigurationDefinition clientKeyData(String clientKeyData) {
        setClientKeyData(clientKeyData);
        return this;
    }

    /**
     * Sets the Client Keystore data that are loaded from the file
     */
    public ToServiceConfigurationDefinition clientKeyFile(String clientKeyFile) {
        setClientKeyFile(clientKeyFile);
        return this;
    }

    /**
     * Sets the Client Keystore passphrase
     */
    public ToServiceConfigurationDefinition clientKeyPassphrase(String clientKeyPassphrase) {
        setClientKeyPassphrase(clientKeyPassphrase);
        return this;
    }

    /**
     * Sets whether to turn on trust certificate check
     */
    public ToServiceConfigurationDefinition trustCerts(boolean trustCerts) {
        setTrustCerts(trustCerts);
        return this;
    }

    /**
     * End of configuration
     */
    public ToServiceDefinition end() {
        return parent;
    }

}
