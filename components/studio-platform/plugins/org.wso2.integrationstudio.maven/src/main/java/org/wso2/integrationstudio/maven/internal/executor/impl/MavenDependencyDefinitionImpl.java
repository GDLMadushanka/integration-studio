package org.wso2.integrationstudio.maven.internal.executor.impl;

import java.net.URL;

import org.wso2.integrationstudio.maven.executor.IMavenDependencyDefinition;

public class MavenDependencyDefinitionImpl extends MavenDefinitionImpl implements IMavenDependencyDefinition {

	private URL resource;
	
	public MavenDependencyDefinitionImpl(String groupId, String artifactId,
			String version) {
		super(groupId, artifactId, version);
	}

	public URL getResource() {
		return resource;
	}

	public void setResource(URL resource) {
		this.resource = resource;
	}

}
