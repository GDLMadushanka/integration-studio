/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.parts.impl;

// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.gmf.esb.parts.JsonTransformMediatorPropertyPropertiesEditionPart;

import org.wso2.integrationstudio.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class JsonTransformMediatorPropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, JsonTransformMediatorPropertyPropertiesEditionPart {

	protected Text propertyName;
	protected Text propertyValue;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public JsonTransformMediatorPropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence jsonTransformMediatorPropertyStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = jsonTransformMediatorPropertyStep.addStep(EsbViewsRepository.JsonTransformMediatorProperty.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyValue);
		
		
		composer = new PartComposer(jsonTransformMediatorPropertyStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.JsonTransformMediatorProperty.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyName) {
					return createPropertyNameText(parent);
				}
				if (key == EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyValue) {
					return createPropertyValueText(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.JsonTransformMediatorPropertyPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createPropertyNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyName, EsbMessages.JsonTransformMediatorPropertyPropertiesEditionPart_PropertyNameLabel);
		propertyName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData propertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		propertyName.setLayoutData(propertyNameData);
		propertyName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(JsonTransformMediatorPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
			}

		});
		propertyName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(JsonTransformMediatorPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}

		});
		EditingUtils.setID(propertyName, EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameText

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyValue, EsbMessages.JsonTransformMediatorPropertyPropertiesEditionPart_PropertyValueLabel);
		propertyValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData propertyValueData = new GridData(GridData.FILL_HORIZONTAL);
		propertyValue.setLayoutData(propertyValueData);
		propertyValue.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(JsonTransformMediatorPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
			}

		});
		propertyValue.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(JsonTransformMediatorPropertyPropertiesEditionPartImpl.this, EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyValue.getText()));
				}
			}

		});
		EditingUtils.setID(propertyValue, EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyValue);
		EditingUtils.setEEFtype(propertyValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyValueText

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.JsonTransformMediatorPropertyPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.JsonTransformMediatorPropertyPropertiesEditionPart#setPropertyName(String newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.JsonTransformMediatorProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.JsonTransformMediatorPropertyPropertiesEditionPart#getPropertyValue()
	 * 
	 */
	public String getPropertyValue() {
		return propertyValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.integrationstudio.gmf.esb.parts.JsonTransformMediatorPropertyPropertiesEditionPart#setPropertyValue(String newValue)
	 * 
	 */
	public void setPropertyValue(String newValue) {
		if (newValue != null) {
			propertyValue.setText(newValue);
		} else {
			propertyValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.JsonTransformMediatorProperty.Properties.propertyValue);
		if (eefElementEditorReadOnlyState && propertyValue.isEnabled()) {
			propertyValue.setEnabled(false);
			propertyValue.setToolTipText(EsbMessages.JsonTransformMediatorProperty_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyValue.isEnabled()) {
			propertyValue.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.JsonTransformMediatorProperty_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
