package org.wso2.integrationstudio.artifact.template.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wso2.integrationstudio.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.integrationstudio.platform.core.model.AbstractListDataProvider;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;
import org.wso2.integrationstudio.project.extensions.templates.ArtifactTemplate;
import org.wso2.integrationstudio.project.extensions.templates.ArtifactTemplateHandler;
import org.wso2.integrationstudio.platform.core.utils.CSProviderConstants;
import org.wso2.integrationstudio.platform.core.utils.IntegrationStudioProviderUtils;

public class TemplateList extends AbstractListDataProvider{

	private static ArtifactTemplate[] artifactTemplates;

	static {
		Map<String,List<String>> filters=new HashMap<String,List<String>> ();
		IntegrationStudioProviderUtils.addFilter(filters,CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_SEQ_TEMPLATE);
		IntegrationStudioProviderUtils.addFilter(filters,CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_ENDPOINT_TEMPLATE);
		setArtifactTemplates(ArtifactTemplateHandler.getArtifactTemplates(filters));
	}
	
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		List<ListData> data = new ArrayList<ListData>();

		if (modelProperty.equals("temp.type")){
			for (ArtifactTemplate template : getArtifactTemplates()) {
				data.add(new EndpointListData(template.getName(), template));
			}
		}
		return data;
	}

	public static void setArtifactTemplates(ArtifactTemplate[] artifactTemplates) {
		TemplateList.artifactTemplates = artifactTemplates;
	}

	public static ArtifactTemplate[] getArtifactTemplates() {
		return artifactTemplates;
	}

	public class EndpointListData extends ListData{

		public EndpointListData(String caption, Object data) {
			super(caption, data);
		}

		
		public boolean equals(Object data) {
			if (data==getData()){
				return true;
			}else if (data==null){
				return false;
			}else if (getData()==null){
				return false;
			}else{
				return ((ArtifactTemplate)data).getId().equals(((ArtifactTemplate)getArtifactTemplate()).getId());
			}
		}

		public ArtifactTemplate getArtifactTemplate(){
			return (ArtifactTemplate)getData();
		}
	}

}
