/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.ds.presentation.custom;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * Custom {@link AdapterFactoryContentProvider} class.
 */
public class CustomAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Creates a new {@link CustomAdapterFactoryContentProvider} instance.
	 * 
	 * @param factory
	 *            {@link AdapterFactory} instance.
	 */
	public CustomAdapterFactoryContentProvider(AdapterFactory factory) {
		super(factory);
	}

	/**
	 * {@inheritDoc}
	 */
	protected IPropertySource createPropertySource(Object object,
	                                               IItemPropertySource itemPropertySource) {
		return new CustomPropertySource(object, itemPropertySource);
	}
}
