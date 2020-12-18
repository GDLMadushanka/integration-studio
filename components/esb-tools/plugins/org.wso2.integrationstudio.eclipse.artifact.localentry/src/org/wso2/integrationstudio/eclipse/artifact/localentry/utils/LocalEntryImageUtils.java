/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.localentry.utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.artifact.localentry.Activator;
import org.wso2.integrationstudio.utils.ui.ImageUtils;

public class LocalEntryImageUtils extends ImageUtils{

	private static ImageUtils instance;

	public static ImageUtils getInstance(){
		if (instance==null){
			instance=new LocalEntryImageUtils();
		}
		return instance;
	}
	
	public Bundle getBundle() {
		return Platform.getBundle(Activator.PLUGIN_ID);
	}

}
