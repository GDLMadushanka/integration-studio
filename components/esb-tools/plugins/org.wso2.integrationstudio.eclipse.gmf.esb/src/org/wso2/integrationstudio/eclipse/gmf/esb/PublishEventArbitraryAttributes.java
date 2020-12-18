/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.integrationstudio.gmf.esb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Publish Event Arbitrary Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.wso2.integrationstudio.gmf.esb.PublishEventArbitraryAttributes#getAttributes
 * <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getPublishEventArbitraryAttributes()
 * @model
 * @generated
 */
public interface PublishEventArbitraryAttributes extends EObject {
    /**
     * Returns the value of the '<em><b>Attributes</b></em>' reference list.
     * The list contents are of type {@link org.wso2.integrationstudio.gmf.esb.PublishEventAttribute}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Attributes</em>' reference list.
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getPublishEventArbitraryAttributes_Attributes()
     * @model
     * @generated
     */
    EList<PublishEventAttribute> getAttributes();

} // PublishEventArbitraryAttributes
