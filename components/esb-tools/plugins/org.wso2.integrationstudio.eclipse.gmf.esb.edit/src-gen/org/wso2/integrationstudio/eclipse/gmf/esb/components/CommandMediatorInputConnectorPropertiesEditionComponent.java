/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.wso2.integrationstudio.gmf.esb.CommandMediatorInputConnector;
import org.wso2.integrationstudio.gmf.esb.EsbLink;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.gmf.esb.parts.CommandMediatorInputConnectorPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class CommandMediatorInputConnectorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for incomingLinks ReferencesTable
	 */
	private ReferencesTableSettings incomingLinksSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CommandMediatorInputConnectorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject commandMediatorInputConnector, String editing_mode) {
		super(editingContext, commandMediatorInputConnector, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CommandMediatorInputConnector.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final CommandMediatorInputConnector commandMediatorInputConnector = (CommandMediatorInputConnector)elt;
			final CommandMediatorInputConnectorPropertiesEditionPart basePart = (CommandMediatorInputConnectorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CommandMediatorInputConnector.Properties.incomingLinks)) {
				incomingLinksSettings = new ReferencesTableSettings(commandMediatorInputConnector, EsbPackage.eINSTANCE.getInputConnector_IncomingLinks());
				basePart.initIncomingLinks(incomingLinksSettings);
			}
			// init filters
			if (isAccessible(EsbViewsRepository.CommandMediatorInputConnector.Properties.incomingLinks)) {
				basePart.addFilterToIncomingLinks(new EObjectFilter(EsbPackage.Literals.ESB_LINK));
				// Start of user code for additional businessfilters for incomingLinks
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}




	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.CommandMediatorInputConnector.Properties.incomingLinks) {
			return EsbPackage.eINSTANCE.getInputConnector_IncomingLinks();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CommandMediatorInputConnector commandMediatorInputConnector = (CommandMediatorInputConnector)semanticObject;
		if (EsbViewsRepository.CommandMediatorInputConnector.Properties.incomingLinks == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof EsbLink) {
					incomingLinksSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				incomingLinksSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				incomingLinksSettings.move(event.getNewIndex(), (EsbLink) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			CommandMediatorInputConnectorPropertiesEditionPart basePart = (CommandMediatorInputConnectorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getInputConnector_IncomingLinks().equals(msg.getFeature())  && isAccessible(EsbViewsRepository.CommandMediatorInputConnector.Properties.incomingLinks))
				basePart.updateIncomingLinks();
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EsbPackage.eINSTANCE.getInputConnector_IncomingLinks()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
