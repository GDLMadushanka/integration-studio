package org.wso2.integrationstudio.gmf.esb.diagram.edit.parts;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.mediators.template.TemplateMediator;
import org.apache.synapse.mediators.template.TemplateParam;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.e4.compatibility.SelectionService;
import org.wso2.integrationstudio.gmf.esb.CallTemplateParameter;
import org.wso2.integrationstudio.gmf.esb.CloudConnectorOperation;
import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.diagram.Activator;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.EditPartDrawingHelper;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer.CloudConnectorOperationDeserializer;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.edit.policies.CloudConnectorOperationCanonicalEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.edit.policies.CloudConnectorOperationItemSemanticEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.integrationstudio.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.utils.file.FileUtils;

/**
 * @generated NOT
 */
public class CloudConnectorOperationEditPart extends FixedSizedAbstractMediator {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3722;

    private String iconPath;

    public IFigure tempPrimaryShape;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * Command for recording user operations.
     */
    private CompoundCommand resultCommand;

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String synapseNS = "http://ws.apache.org/ns/synapse";
    private Properties properties = new Properties();

    /**
     * @generated
     */
    public CloudConnectorOperationEditPart(View view) {
        super(view);
    }

    public void setIconPath() {
        /*
         * This method should be rewrite to set the icon path properly.
         */
        IProject project = EditorUtils.getActiveProject();
        if (project == null) {
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            try {
                project = getProject(((SelectionService) window.getSelectionService()).getSelection());
            } catch (Exception e) {
                log.error("Error while getting the project", e);
            }
        }

        String connectorName = ((CloudConnectorOperation) ((Node) getModel()).getElement()).getCloudConnectorName();
        if (connectorName == null) {
            connectorName = CloudConnectorOperationDeserializer.cloudConnectorName;
        }

        if (project == null) {
            try {
                project = ((IFileEditorInput) EsbMultiPageEditor.currentEditor.getEditorInput()).getFile().getProject();
                // project = getProject(EsbMultiPageEditor.currentEditor.getSite().getPage().getSelection());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        String connectorPath = CloudConnectorDirectoryTraverser.getInstance()
                .getConnectorDirectoryPathFromConnectorName(project.getWorkspace().getRoot().getLocation().toOSString(),
                        connectorName);
        iconPath = connectorPath + File.separator + "icon" + File.separator + "icon-large.png";
        File icon = new File(iconPath);
        if (!icon.exists()) {
            iconPath = connectorPath + File.separator + "icon" + File.separator + "icon-large.gif";
        }

    }

    public static IProject getProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getProject(((IStructuredSelection) obj).getFirstElement());
        }
        return null;
    }

    private CompoundCommand getResultCommand() {
        if (null == resultCommand) {
            resultCommand = new CompoundCommand();
        }
        return resultCommand;
    }

    public void fillConnectorOperationParameters() {
        String addedConnector = ((CloudConnectorOperation) ((Node) getModel()).getElement()).getCloudConnectorName();
        String addedOperation = ((CloudConnectorOperation) ((Node) getModel()).getElement()).getOperationName();
        TransactionalEditingDomain editingDomain = null;
        IProject activeProject = EditorUtils.getActiveProject();
        if (activeProject != null) {
            if (addedConnector != null && addedOperation != null) {
                String connectorPath = CloudConnectorDirectoryTraverser.getInstance()
                        .getConnectorDirectoryPathFromConnectorName(
                                activeProject.getWorkspace().getRoot().getLocation().toOSString(), addedConnector);

                CloudConnectorDirectoryTraverser cloudConnectorDirectoryTraverser = CloudConnectorDirectoryTraverser
                        .getInstance(connectorPath);
                String directory = null;
                String operationFileName = null;
                try {
                    operationFileName = cloudConnectorDirectoryTraverser.getOperationsMap().get(addedOperation);
                    directory = cloudConnectorDirectoryTraverser.getOperationFileNamesMap().get(operationFileName);
                } catch (Exception e1) {
                    log.error("Error while retrieving data for connector", e1);
                }
                String path = connectorPath + File.separator + directory + File.separator + operationFileName + ".xml";
                addedOperation = null;

                try {
                    String source = FileUtils.getContentAsString(new File(path));
                    OMElement element = AXIOMUtil.stringToOM(source);

                    if (element.getFirstChildWithName(new QName(synapseNS, "sequence", null)) != null) {
                        TemplateMediatorFactory templateMediatorFactory = new TemplateMediatorFactory();
                        TemplateMediator templateMediator = (TemplateMediator) templateMediatorFactory
                                .createMediator(element, properties);
                        editingDomain = getEditingDomain();
                        DeleteCommand modelDeleteCommand = new DeleteCommand(editingDomain,
                                ((CloudConnectorOperation) ((Node) getModel()).getElement()).getConnectorParameters());
                        if (modelDeleteCommand.canExecute()) {
                            editingDomain.getCommandStack().execute(modelDeleteCommand);
                        }
                        for (TemplateParam parameter : templateMediator.getParameters()) {
                            final CallTemplateParameter callTemplateParameter = EsbFactory.eINSTANCE
                                    .createCallTemplateParameter();
                            callTemplateParameter.setParameterName(parameter.getName());
                            RecordingCommand command = new RecordingCommand(editingDomain) {
                                protected void doExecute() {
                                    ((CloudConnectorOperation) ((Node) getModel()).getElement())
                                            .getConnectorParameters().add(callTemplateParameter);
                                }
                            };
                            if (command.canExecute()) {
                                editingDomain.getCommandStack().execute(command);
                            }
                        }
                    }
                } catch (XMLStreamException e) {
                    log.error("Error occured while parsing selected template file", e);
                } catch (IOException e) {
                    log.error("Error occured while reading selected template file", e);
                }
            }
        }
    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE,
                new CreationEditPolicyWithCustomReparent(EsbVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CloudConnectorOperationItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CloudConnectorOperationCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // For handle Double click Event.
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (EsbVisualIDRegistry.getVisualID(childView)) {
                case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
                case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy();
                }
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated NOT
     */
    protected IFigure createNodeShape() {
        primaryShape = new CloudConnectorOperationFigure(new Color(null, 104, 159, 56)) {
            public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
                super.setBounds(rect);
                if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
                    connectToMostSuitableElement();
                    reAllocate(rect);
                }
            };
        };
        tempPrimaryShape = primaryShape;
        return primaryShape;
    }

    /**
     * @generated
     */
    public CloudConnectorOperationFigure getPrimaryShape() {
        return (CloudConnectorOperationFigure) primaryShape;
    }

    /**
     * @generated NOT
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof CloudConnectorOperationDescriptionEditPart) {
            ((CloudConnectorOperationDescriptionEditPart) childEditPart)
                    .setLabel(getPrimaryShape().getFigureCloudConnectorOperationDescriptionFigure());
            return true;
        }
        if (childEditPart instanceof CloudConnectorOperationInputConnectorEditPart) {
            IFigure borderItemFigure = ((CloudConnectorOperationInputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.WEST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        if (childEditPart instanceof CloudConnectorOperationOutputConnectorEditPart) {
            IFigure borderItemFigure = ((CloudConnectorOperationOutputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.EAST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof CloudConnectorOperationDescriptionEditPart) {
            return true;
        }
        if (childEditPart instanceof CloudConnectorOperationInputConnectorEditPart) {
            getBorderedFigure().getBorderItemContainer()
                    .remove(((CloudConnectorOperationInputConnectorEditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof CloudConnectorOperationOutputConnectorEditPart) {
            getBorderedFigure().getBorderItemContainer()
                    .remove(((CloudConnectorOperationOutputConnectorEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    /**
     * @generated
     */
    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
     * @generated
     */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof IBorderItemEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        return getContentPane();
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated NOT
     */
    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new ToolbarLayout(true));
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
     * @param nodeShape instance of generated figure class
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated
     */
    public EditPart getPrimaryChildEditPart() {
        return getChildBySemanticHint(
                EsbVisualIDRegistry.getType(CloudConnectorOperationDescriptionEditPart.VISUAL_ID));
    }

    /**
     * @generated NOT
     */
    public class CloudConnectorOperationFigure extends EsbGraphicalShapeWithLabel {

        int Figure_PreferredWidth = FixedSizedAbstractMediator.FigureWidth;
        int Figure_PreferredHeight = FixedSizedAbstractMediator.FigureHeight + 20; // Additional 20 to show the editable
                                                                                   // label
        int Image_PreferredWidth = 72;
        int Image_PreferredHeight = 80;
        int marginWidth = (Figure_PreferredWidth - Image_PreferredWidth) / 2; // equals to 10
        int marginHeight = 10;

        /**
         * @generated
         */
        private WrappingLabel fFigureCloudConnectorOperationDescriptionFigure;

        /**
         * @generated NOT
         */
        public CloudConnectorOperationFigure(Color borderColor) {
            super(borderColor, false);
            this.setBackgroundColor(THIS_BACK);
            createContents();
        }

        /**
         * @generated NOT
         */
        private void createContents() {

            fFigureCloudConnectorOperationDescriptionFigure = new WrappingLabel();

            fFigureCloudConnectorOperationDescriptionFigure.setText("<...>");

            fFigureCloudConnectorOperationDescriptionFigure = getPropertyNameLabel();

        }

        public void setCloudConnectorImage() {
            GridData constraintMainImageRectangle = new GridData();
            constraintMainImageRectangle.verticalAlignment = GridData.BEGINNING;
            constraintMainImageRectangle.horizontalAlignment = GridData.CENTER;
            constraintMainImageRectangle.verticalSpan = 1;

            ImageFigure iconImageFigure = EditPartDrawingHelper.getIconImageFigure(iconPath, Image_PreferredWidth,
                    Image_PreferredHeight);

            mainImageRectangle = new RoundedRectangle();
            mainImageRectangle.setCornerDimensions(new Dimension(8, 8));
            mainImageRectangle.setOutline(false);
            mainImageRectangle.setPreferredSize(new Dimension(Image_PreferredWidth, Image_PreferredHeight));
            mainImageRectangle.add(iconImageFigure);
            figureLayer.removeAll();
            figureLayer.add(mainImageRectangle, constraintMainImageRectangle);
            figureLayer.add(tempPropertyValueRectangle1, tempConstraintPropertyValueRectangle);
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureCloudConnectorOperationDescriptionFigure() {
            return fFigureCloudConnectorOperationDescriptionFigure;
        }

        public String getIconPath() {
            return "icons/ico20/log-mediator.png";
        }

        public String getNodeName() {
            return "Connector";
        }

        public IFigure getToolTip() {
            return new Label("Connect with Cloud");
        }

    }

    /**
     * @generated
     */
    static final Color THIS_BACK = new Color(null, 255, 255, 255);

}
