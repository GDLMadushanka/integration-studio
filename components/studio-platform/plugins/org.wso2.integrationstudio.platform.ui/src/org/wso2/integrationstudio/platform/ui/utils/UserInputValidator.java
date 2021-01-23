/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.platform.ui.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {

    public static boolean isRepositoryValid(String dockerRepo) {
        Pattern pattern = Pattern.compile(PlatformUIConstants.DOCKER_REPO_REGEX);
        Matcher matcher = pattern.matcher(dockerRepo);
        return matcher.matches();
    }

    public static boolean isTagValid(String dockertag) {
    	if ("${project.version}".equals(dockertag)) {
    		return true;
    	}
        Pattern pattern = Pattern.compile(PlatformUIConstants.DOCKER_TAG_REGEX);
        Matcher matcher = pattern.matcher(dockertag);
        return matcher.matches();
    }
}
