package org.wso2.integrationstudio.gmf.esb.diagram.custom.provider;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.wso2.integrationstudio.gmf.esb.RuleMediator;
import org.wso2.integrationstudio.gmf.esb.ScriptMediator;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.configure.ui.ConfigureRuleMediatorFactsDialog;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.configure.ui.ConfigureScriptKeysDialog;

public class ScriptKeysPropertyDescriptor extends PropertyDescriptor {

    public ScriptKeysPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
        super(object, itemPropertyDescriptor);
    }

    public CellEditor createPropertyEditor(Composite parent) {
        return new ExtendedDialogCellEditor(parent, getLabelProvider()) {

            protected Object openDialogBox(Control cellEditorWindow) {
                Shell shell = Display.getDefault().getActiveShell();
                ScriptMediator ruleMediator = (ScriptMediator) object;
                ConfigureScriptKeysDialog configurationDialog = new ConfigureScriptKeysDialog(shell, ruleMediator,
                        TransactionUtil.getEditingDomain(ruleMediator));
                configurationDialog.setBlockOnOpen(true);
                configurationDialog.open();
                return null;
            }
        };
    }

}
