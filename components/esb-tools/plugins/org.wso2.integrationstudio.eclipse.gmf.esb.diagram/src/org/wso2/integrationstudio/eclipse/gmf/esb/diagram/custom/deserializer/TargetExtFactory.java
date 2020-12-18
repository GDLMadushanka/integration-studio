/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.mediators.eip.Target;

import javax.xml.namespace.QName;
import java.util.Properties;

/**
 * Factory for {@link Target} instances.
 * <p>
 * This will build the Target util object for EIP mediators using
 * &lt;target&gt; element specified as follows
 *
 * &lt;target (sequence="string reference")? (endpoint="string reference")?&gt;
 *  (&lt;sequence&gt; | &lt;endpoinit&gt;)?
 * &lt;/target&gt;
 */
public class TargetExtFactory {

    private static final String NULL_NAMESPACE = "";
    private static final String SYNAPSE_NAMESPACE = "http://ws.apache.org/ns/synapse";
    
    /**
     * Holds the QName of the target element in the xml configuration
     */
    private static final QName TARGET_Q = new QName(SYNAPSE_NAMESPACE, "target");

    /**
     * This static method will be used to build the Target from the specified element
     * 
     * @param elem - OMElement describing the xml configuration of the target
     * @param properties bag of properties with information 
     * @return Target built by parsing the given element
     */
    public static Target createTarget(OMElement elem, Properties properties) {

        if (!TARGET_Q.equals(elem.getQName())) {
            handleException("Element does not match with the target QName");
        }

        Target target = new Target();
        OMAttribute toAttr = elem.getAttribute(new QName(NULL_NAMESPACE, "to"));
        if (toAttr != null && toAttr.getAttributeValue() != null) {
            target.setToAddress(toAttr.getAttributeValue());
        }

        OMAttribute soapAction = elem.getAttribute(
                new QName(NULL_NAMESPACE, "soapAction"));
        if (soapAction != null && soapAction.getAttributeValue() != null) {
            target.setSoapAction(soapAction.getAttributeValue());
        }

        OMAttribute sequenceAttr = elem.getAttribute(
                new QName(NULL_NAMESPACE, "sequence"));
        if (sequenceAttr != null && sequenceAttr.getAttributeValue() != null) {
            target.setSequenceRef(sequenceAttr.getAttributeValue());
        }

        OMAttribute endpointAttr = elem.getAttribute(
                new QName(NULL_NAMESPACE, "endpoint"));
        if (endpointAttr != null && endpointAttr.getAttributeValue() != null) {
            target.setEndpointRef(endpointAttr.getAttributeValue());
        }

        OMElement sequence = elem.getFirstChildWithName(
                new QName(SYNAPSE_NAMESPACE, "sequence"));
        if (sequence != null) {
            SequenceMediatorExtFactory fac = SequenceMediatorExtFactory.getInstance();
            target.setSequence(fac.createAnonymousSequence(sequence, properties));
        }

        OMElement endpoint = elem.getFirstChildWithName(
                new QName(SYNAPSE_NAMESPACE, "endpoint"));
        if (endpoint != null) {
            target.setEndpoint(EndpointFactory.getEndpointFromElement(endpoint, true, properties));
        }

        return target;
    }

    /**
     * This private method is used for exception handling and logging purposes.
     *
     * @param message - String message to be logged and the message of the exception
     */
    private static void handleException (String message) {
        throw new SynapseException(message);
    }
}
