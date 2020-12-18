/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.integrationstudio.gmf.esb.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.AbstractBaseFigureInputConnectorEditPart;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.AbstractOutputConnectorEditPart;
import org.wso2.integrationstudio.gmf.esb.diagram.edit.policies.ProxyInputConnectorItemSemanticEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.utils.ImageHolder;

/**
 * @generated NOT
 */
public class ProxyInputConnectorEditPart extends AbstractBaseFigureInputConnectorEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3003;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    protected IFigure primaryShape;

    public final boolean isInput = true;

    /**
     * @generated
     */
    public ProxyInputConnectorEditPart(View view) {
        super(view);
    }

    public NodeFigure figure_;

    public NodeFigure getNodeFigureInput() {

        return figure_;
    }

    /**
     * @generated NOT
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ProxyInputConnectorItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
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
     * @generated
     */
    protected IFigure createNodeShape() {
        return primaryShape = new WestPointerFigure();
    }

    /**
     * @generated
     */
    public WestPointerFigure getPrimaryShape() {
        return (WestPointerFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(12, 10);

        // FIXME: workaround for #154536
        result.getBounds().setSize(result.getPreferredSize());
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated NOT
     */
    protected NodeFigure createNodeFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        figure_ = figure;

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
    public List<IElementType> getMARelTypesOnTarget() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(1);
        types.add(EsbElementTypes.EsbLink_4001);
        return types;
    }

    /**
     * @generated
     */
    public List<IElementType> getMATypesForSource(IElementType relationshipType) {
        LinkedList<IElementType> types = new LinkedList<IElementType>();
        if (relationshipType == EsbElementTypes.EsbLink_4001) {
            types.add(EsbElementTypes.ProxyOutputConnector_3002);
            types.add(EsbElementTypes.MessageOutputConnector_3047);
            types.add(EsbElementTypes.DefaultEndPointOutputConnector_3022);
            types.add(EsbElementTypes.AddressEndPointOutputConnector_3031);
            types.add(EsbElementTypes.FilterMediatorPassOutputConnector_3011);
            types.add(EsbElementTypes.FilterMediatorFailOutputConnector_3012);
            types.add(EsbElementTypes.MergeNodeOutputConnector_3016);
            types.add(EsbElementTypes.LogMediatorOutputConnector_3019);
            types.add(EsbElementTypes.PropertyMediatorOutputConnector_3034);
            types.add(EsbElementTypes.PropertyGroupMediatorOutputConnector_3790);
            types.add(EsbElementTypes.EnrichMediatorOutputConnector_3037);
            types.add(EsbElementTypes.XSLTMediatorOutputConnector_3040);
            types.add(EsbElementTypes.SwitchCaseBranchOutputConnector_3043);
            types.add(EsbElementTypes.SwitchDefaultBranchOutputConnector_3044);
            types.add(EsbElementTypes.SequenceOutputConnector_3050);
            types.add(EsbElementTypes.EventMediatorOutputConnector_3053);
            types.add(EsbElementTypes.EntitlementMediatorOutputConnector_3056);
            types.add(EsbElementTypes.ClassMediatorOutputConnector_3059);
            types.add(EsbElementTypes.SpringMediatorOutputConnector_3062);
            types.add(EsbElementTypes.ScriptMediatorOutputConnector_3065);
            types.add(EsbElementTypes.FaultMediatorOutputConnector_3068);
            types.add(EsbElementTypes.XQueryMediatorOutputConnector_3071);
            types.add(EsbElementTypes.CommandMediatorOutputConnector_3074);
            types.add(EsbElementTypes.DBLookupMediatorOutputConnector_3077);
            types.add(EsbElementTypes.DBReportMediatorOutputConnector_3080);
            types.add(EsbElementTypes.SmooksMediatorOutputConnector_3083);
            types.add(EsbElementTypes.SendMediatorOutputConnector_3086);
            types.add(EsbElementTypes.JsonTransformMediatorOutputConnector_3793);
        }
        return types;
    }

    /**
     * @generated NOT
     */
    public class WestPointerFigure extends RoundedRectangle {

        public WestPointerFigure() {

            /*
             * this.setBackgroundColor(THIS_BACK); this.setPreferredSize(new
             * Dimension(getMapMode().DPtoLP(12), getMapMode().DPtoLP(10)));
             */

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.marginHeight = 0;
            layoutThis.marginWidth = 1;
            this.setLayoutManager(layoutThis);

            this.setCornerDimensions(new Dimension(1, 1));
            this.setFill(false);
            this.setOutline(false);
            // this.setBackgroundColor(get);
            this.setPreferredSize(new Dimension(12, 9));
            createContents();

        }

        public void createContents() {
            GridData constraintImageRectangle11 = new GridData();
            constraintImageRectangle11.verticalAlignment = GridData.FILL;
            constraintImageRectangle11.horizontalAlignment = GridData.FILL;
            constraintImageRectangle11.horizontalIndent = 0;
            constraintImageRectangle11.horizontalSpan = 1;
            constraintImageRectangle11.verticalSpan = 2;
            constraintImageRectangle11.grabExcessHorizontalSpace = true;
            constraintImageRectangle11.grabExcessVerticalSpace = true;

            ImageFigure img1 = new ImageFigure(ImageHolder.getInstance().getArrowWestImage());
            img1.setSize(new Dimension(12, 9));

            RectangleFigure imageRectangle11 = new RectangleFigure();
            imageRectangle11.setOutline(false);
            imageRectangle11.setBackgroundColor(new Color(null, 255, 255, 255));
            imageRectangle11.setPreferredSize(new Dimension(12, 9));
            imageRectangle11.add(img1);

            this.add(imageRectangle11, constraintImageRectangle11);

        }

    }

    @Override
    public Command getCommand(Request request) {
        if (request instanceof CreateConnectionViewAndElementRequest) {
            CreateConnectionViewAndElementRequest req = (CreateConnectionViewAndElementRequest) request;
            EditPart sourceConnection = req.getSourceEditPart();
            if (sourceConnection instanceof AbstractOutputConnectorEditPart) {
                if (sourceConnection.getParent() instanceof EditPart) {
                    /* check whether source is a child of proxy-service sequence & end-point compartment */
                    if (!(sourceConnection.getParent()
                            .getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart)) {
                        return UnexecutableCommand.INSTANCE;
                    }
                }
            }
        }
        return super.getCommand(request);
    }

    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * @generated
     */
    static final Color THIS_BACK = new Color(null, 50, 50, 50);

}
