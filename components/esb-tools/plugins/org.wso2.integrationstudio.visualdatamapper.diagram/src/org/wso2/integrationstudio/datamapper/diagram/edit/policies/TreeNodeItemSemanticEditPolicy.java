package org.wso2.integrationstudio.datamapper.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.integrationstudio.datamapper.diagram.edit.commands.ElementCreateCommand;
import org.wso2.integrationstudio.datamapper.diagram.edit.commands.InNodeCreateCommand;
import org.wso2.integrationstudio.datamapper.diagram.edit.commands.OutNodeCreateCommand;
import org.wso2.integrationstudio.datamapper.diagram.edit.commands.TreeNode2CreateCommand;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.DataMapperLinkEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.ElementEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.part.DataMapperVisualIDRegistry;
import org.wso2.integrationstudio.datamapper.diagram.providers.DataMapperElementTypes;

/**
 * @generated
 */
public class TreeNodeItemSemanticEditPolicy extends DataMapperBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TreeNodeItemSemanticEditPolicy() {
		super(DataMapperElementTypes.TreeNode_3002);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (DataMapperElementTypes.Element_3007 == req.getElementType()) {
			return getGEFWrapper(new ElementCreateCommand(req));
		}
		if (DataMapperElementTypes.TreeNode_3003 == req.getElementType()) {
			return getGEFWrapper(new TreeNode2CreateCommand(req));
		}
		if (DataMapperElementTypes.InNode_3020 == req.getElementType()) {
			return getGEFWrapper(new InNodeCreateCommand(req));
		}
		if (DataMapperElementTypes.OutNode_3019 == req.getElementType()) {
			return getGEFWrapper(new OutNodeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (DataMapperVisualIDRegistry.getVisualID(node)) {
			case ElementEditPart.VISUAL_ID:
				cmd.add(new DestroyElementCommand(
						new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case TreeNode2EditPart.VISUAL_ID:
				cmd.add(new DestroyElementCommand(
						new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case InNodeEditPart.VISUAL_ID:
				for (Iterator<?> it = node.getTargetEdges().iterator(); it.hasNext();) {
					Edge incomingLink = (Edge) it.next();
					if (DataMapperVisualIDRegistry.getVisualID(incomingLink) == DataMapperLinkEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(
						new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			case OutNodeEditPart.VISUAL_ID:
				for (Iterator<?> it = node.getSourceEdges().iterator(); it.hasNext();) {
					Edge outgoingLink = (Edge) it.next();
					if (DataMapperVisualIDRegistry.getVisualID(outgoingLink) == DataMapperLinkEditPart.VISUAL_ID) {
						DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
						cmd.add(new DestroyElementCommand(r));
						cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
						continue;
					}
				}
				cmd.add(new DestroyElementCommand(
						new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
				// don't need explicit deletion of node as parent's view deletion would clean child views as well 
				// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
				break;
			}
		}
	}

}
