package com.btc.ac.labs.project.requirement.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class Operations {
	private Text text;
	private Display display;
	
	@PostConstruct
	
	public void createOper( Composite parent){
		
		parent.setLayout(new GridLayout(2, false));

        // text = new Text(parent, SWT.BORDER);
         
         Label labelName = new Label(parent, SWT.NONE);
 		labelName.setText("Name: ");
 		Text textName = new Text(parent, SWT.BORDER);
 		
 		Label labelsDescription = new Label(parent, SWT.NONE);
 		labelsDescription.setText("Long Description: ");
 				Text TshortDescription = new Text(parent, SWT.BORDER);
 		
 		Label labellDescription = new Label(parent, SWT.NONE);
 		labellDescription.setText("Long Description: ");
 		Text TlongDescription = new Text(parent, SWT.BORDER);
 		
 		Label lCreator = new Label(parent, SWT.NONE);
 		lCreator.setText("Creator: ");
 		Text Tcreator = new Text(parent, SWT.BORDER);
 		
 		Label lcreationDate= new Label(parent, SWT.NONE);
 		lcreationDate.setText("Description: ");
 		Text TcreationDate = new Text(parent, SWT.BORDER);
 		
 		Label modiDate = new Label(parent, SWT.NONE);
 		modiDate.setText("Description: ");
 		Text TmodifyDate = new Text(parent, SWT.BORDER);
 		
 	
 		
 		
 		 final Tree tree = new Tree(parent, SWT.V_SCROLL);
         for (int i = 1; i < 5; i++) {
             TreeItem item = new TreeItem(tree, SWT.NONE);
             item.setText(String.valueOf(i));
             for (int j = 0; j < 4; j++) {
                 TreeItem subItem = new TreeItem(item, SWT.NONE);
                 subItem.setText(String.valueOf(i) + " " + String.valueOf(j));
             }
         }
         tree.pack();
         Menu menu = new Menu(tree);
         MenuItem menuItem = new MenuItem(menu, SWT.NONE);
         menuItem.setText("Print Element");
         menuItem.addSelectionListener(new SelectionAdapter() {
        	 
        	 public void widgetSelected(SelectionEvent event) {
                 System.out.println(tree.getSelection()[1].getText());
             }
         });
	
         tree.setMenu(menu);
         parent.pack();
        // parent.open();
         while (!parent.isDisposed()) {
             if (!display.readAndDispatch()) {
                 display.sleep();
             }
         }
 		
	}
	
    
}


