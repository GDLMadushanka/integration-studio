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
import org.wso2.integrationstudio.gmf.esb.ClassMediator;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.configure.ui.ConfigureClassMediatorDialog;

public class ClassConfigurationPropertyDescriptor extends PropertyDescriptor {

    public ClassConfigurationPropertyDescriptor(Object object, IItemPropertyDescriptor itemPropertyDescriptor) {
        super(object, itemPropertyDescriptor);
    }

    public CellEditor createPropertyEditor(Composite parent) {
        return new ExtendedDialogCellEditor(parent, getLabelProvider()) {

            protected Object openDialogBox(Control cellEditorWindow) {
                Shell shell = Display.getDefault().getActiveShell();
                ClassMediator classMediator = (ClassMediator) object;
                // .getEditingDomain()
                ConfigureClassMediatorDialog classMediatorConfigurationDialog = new ConfigureClassMediatorDialog(shell,
                        classMediator, TransactionUtil.getEditingDomain(classMediator));
                classMediatorConfigurationDialog.setBlockOnOpen(true);
                classMediatorConfigurationDialog.open();
                return null;
            }
        };
    }

}
