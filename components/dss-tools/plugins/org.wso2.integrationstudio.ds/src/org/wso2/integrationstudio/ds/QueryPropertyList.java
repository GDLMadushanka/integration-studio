/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.integrationstudio.ds;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Property List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.ds.QueryPropertyList#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.ds.QueryPropertyList#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.ds.DsPackage#getQueryPropertyList()
 * @model extendedMetaData="name='properties_._type' kind='mixed'"
 * @generated
 */
public interface QueryPropertyList extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.wso2.integrationstudio.ds.DsPackage#getQueryPropertyList_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.integrationstudio.ds.QueryProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.wso2.integrationstudio.ds.DsPackage#getQueryPropertyList_Property()
	 * @model containment="true" upper="5" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<QueryProperty> getProperty();

} // QueryPropertyList
