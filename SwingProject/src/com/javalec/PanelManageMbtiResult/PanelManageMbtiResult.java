package com.javalec.PanelManageMbtiResult;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.Datadefine.data_Enviroment_define;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PanelManageMbtiResult extends JPanel {
	private JScrollPane scrollPane_AdMBTIResult;
	private final DefaultTableModel Outer_Table_AdMBTIResult = new DefaultTableModel(); // ################
	private JTable inner_table_AdMBTIResult;
	private JLabel lblAdMBTIResultName;
	private JLabel lbAdMBTIResultarExplain;
	private JTextField tfAdMBTIResultName;
	private JTextField tfAdMBTIResultarExplain;
	private JButton btnAdMBTIResultEdit;
	private JButton btnAdMBTIResultRemove;
	private JLabel lblAdMBTIResultNum;
	private JTextField tfAdMBTIResultNum;
	private JLabel lblMbti;
	private JTextField tfAdMBTIResultType;
	private JLabel lblMbti_1;
	private JTextField tfFilePath;
	private JButton btnFilePath;
	private JLabel lbImage;

	/**
	 * Create the panel.
	 */
	public PanelManageMbtiResult() {
		setBackground(new Color(238, 238, 238));
		setBounds(new Rectangle(0, 57, 500, 350));
		setLayout(null);
		add(getScrollPane_AdMBTIResult());
		add(getLblAdMBTIResultName());
		add(getlblAdMBTIResultExplanation());
		add(getTfAdMBTIResultName());
		add(getTfAdMBTIResultarExplain());
		add(getBtnAdMBTIResultEdit());
		add(getBtnAdMBTIResultRemove());
		add(getLblAdMBTIResultNum());
		add(getTfAdMBTIResultNum());
		add(getLblMbti());
		add(getTfAdMBTIResultType());
		add(getLblMbti_1());
		add(getTfFilePath());
		add(getBtnFilePath());
		add(getLbImage());
		
		

	}
	private JScrollPane getScrollPane_AdMBTIResult() {
		if (scrollPane_AdMBTIResult == null) {
			scrollPane_AdMBTIResult = new JScrollPane();
			scrollPane_AdMBTIResult.setBounds(12, 17, 360, 125);
			scrollPane_AdMBTIResult.setViewportView(getInner_table_AdMBTIResult());
		}
		return scrollPane_AdMBTIResult;
	}
	private JTable getInner_table_AdMBTIResult() {
		if (inner_table_AdMBTIResult == null) {
			inner_table_AdMBTIResult = new JTable();
			inner_table_AdMBTIResult.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MMR_TableClick();
				}
			});
			inner_table_AdMBTIResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_table_AdMBTIResult.setModel(Outer_Table_AdMBTIResult); // ???????????? ???????????? ?????? ******??? ????????? ???*****
			MMR_TableInit();
			MMR_selectList();
		}
			return inner_table_AdMBTIResult;
		}
	
	private JLabel getLblAdMBTIResultName() {
		if (lblAdMBTIResultName == null) {
			lblAdMBTIResultName = new JLabel("MBTI??????");
			lblAdMBTIResultName.setBounds(12, 227, 60, 16);
		}
		return lblAdMBTIResultName;
	}
	private JLabel getlblAdMBTIResultExplanation() {
		if (lbAdMBTIResultarExplain == null) {
			lbAdMBTIResultarExplain = new JLabel("MBTI??????");
			lbAdMBTIResultarExplain.setBounds(12, 260, 61, 16);
		}
		return lbAdMBTIResultarExplain;
	}
	
	private JTextField getTfAdMBTIResultName() {
		if (tfAdMBTIResultName == null) {
			tfAdMBTIResultName = new JTextField();
			tfAdMBTIResultName.setBounds(90, 225, 398, 26);
			tfAdMBTIResultName.setColumns(10);
		}
		return tfAdMBTIResultName;
	}
	private JTextField getTfAdMBTIResultarExplain() {
		if (tfAdMBTIResultarExplain == null) {
			tfAdMBTIResultarExplain = new JTextField();
			tfAdMBTIResultarExplain.setColumns(10);
			tfAdMBTIResultarExplain.setBounds(90, 256, 398, 54);
		}
		return tfAdMBTIResultarExplain;
	}
	private JButton getBtnAdMBTIResultEdit() {
		if (btnAdMBTIResultEdit == null) {
			btnAdMBTIResultEdit = new JButton("??????");
			btnAdMBTIResultEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MMR_Action(2);
				}
			});
			btnAdMBTIResultEdit.setBounds(253, 320, 60, 29);
		}
		return btnAdMBTIResultEdit;
	}
	private JButton getBtnAdMBTIResultRemove() {
		if (btnAdMBTIResultRemove == null) {
			btnAdMBTIResultRemove = new JButton("??????");
			btnAdMBTIResultRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MMR_Action(3);
				}
			});
			btnAdMBTIResultRemove.setBounds(428, 320, 60, 29);
		}
		return btnAdMBTIResultRemove;
	}
	private JLabel getLblAdMBTIResultNum() {
		if (lblAdMBTIResultNum == null) {
			lblAdMBTIResultNum = new JLabel("??????");
			lblAdMBTIResultNum.setBounds(12, 158, 27, 16);
		}
		return lblAdMBTIResultNum;
	}
	private JTextField getTfAdMBTIResultNum() {
		if (tfAdMBTIResultNum == null) {
			tfAdMBTIResultNum = new JTextField();
			tfAdMBTIResultNum.setEditable(false);
			tfAdMBTIResultNum.setColumns(10);
			tfAdMBTIResultNum.setBounds(90, 154, 66, 26);
		}
		return tfAdMBTIResultNum;
	}
	
	private JLabel getLblMbti() {
		if (lblMbti == null) {
			lblMbti = new JLabel("MBTI??????");
			lblMbti.setBounds(12, 195, 60, 16);
		}
		return lblMbti;
	}
	private JTextField getTfAdMBTIResultType() {
		if (tfAdMBTIResultType == null) {
			tfAdMBTIResultType = new JTextField();
			tfAdMBTIResultType.setColumns(10);
			tfAdMBTIResultType.setBounds(90, 191, 66, 26);
		}
		return tfAdMBTIResultType;
	}
	
	private JLabel getLblMbti_1() {
		if (lblMbti_1 == null) {
			lblMbti_1 = new JLabel("????????? ????????????");
			lblMbti_1.setBounds(196, 159, 96, 16);
		}
		return lblMbti_1;
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(298, 154, 190, 26);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("????????????");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();;
				}
			});
			btnFilePath.setBounds(391, 184, 97, 23);
		}
		return btnFilePath;
	}
	private JLabel getLbImage() {
		if (lbImage == null) {
			lbImage = new JLabel("");
			lbImage.setIcon(new ImageIcon(""));
			lbImage.setHorizontalAlignment(SwingConstants.CENTER);
			lbImage.setBounds(384, 17, 100, 125);
		}
		return lbImage;
	}
	
	//-------------------------------
	//??????????????? 
	//-------------------------------
	
	//Dowoo 2021.04.28  ??????

	//?????????????????? Dowoo 2021.04.28 ???????????? ??????	
		public void MMR_TableInit() {	
			//????????? User table ??????
			Outer_Table_AdMBTIResult.addColumn("??????");
			Outer_Table_AdMBTIResult.addColumn("??????");
			Outer_Table_AdMBTIResult.addColumn("??????");
			Outer_Table_AdMBTIResult.addColumn("??????");
			Outer_Table_AdMBTIResult.setColumnCount(4); 
			
			int i = Outer_Table_AdMBTIResult.getRowCount();
			for(int j=0; j<i; j++) {
				Outer_Table_AdMBTIResult.removeRow(0);
			}
			
			inner_table_AdMBTIResult.setAutoResizeMode(inner_table_AdMBTIResult.AUTO_RESIZE_OFF); // ???????????? ???????????? x
			
			int vColIndex = 0; // ????????? ???
			TableColumn col = inner_table_AdMBTIResult.getColumnModel().getColumn(vColIndex);
			int width = 30; // ????????? ??? ??????
			col.setPreferredWidth(width);; // ????????? ??? ???????????? ??????
			
			vColIndex = 1; // 2?????? ???
			col = inner_table_AdMBTIResult.getColumnModel().getColumn(vColIndex);
			width = 50; // 2?????? ??? ??????
			col.setPreferredWidth(width);; // 2?????? ??? ???????????? ??????
			
			vColIndex = 2; // 3?????? ???
			col = inner_table_AdMBTIResult.getColumnModel().getColumn(vColIndex);
			width = 70; // 3?????? ??? ??????
			col.setPreferredWidth(width);; // 3?????? ??? ???????????? ??????
			
			vColIndex = 3; // 4?????? ???
			col = inner_table_AdMBTIResult.getColumnModel().getColumn(vColIndex);
			width = 250; // 4?????? ??? ??????
			col.setPreferredWidth(width);; // 4?????? ??? ???????????? ??????

			
		}
		//????????? ?????????
		public void MMR_ClearColumn() {
			tfAdMBTIResultarExplain.setText("");
			tfAdMBTIResultName.setText("");
			tfAdMBTIResultNum.setText("");
			tfAdMBTIResultType.setText("");
		}

		//???????????? Dowoo 2021.04.29
		public void MMR_selectList(){

			MMR_DbAction dbAction = new MMR_DbAction();
			ArrayList<MMR_Bean> beanlList = dbAction.MMR_selectList();
			
			int listCount =beanlList.size();
			
			for(int i=0; i<listCount; i++) {
				String temp =Integer.toString(beanlList.get(i).getMrNum());
				String[] qtxt = {temp,beanlList.get(i).getMrType(), beanlList.get(i).getMrName(),beanlList.get(i).getMrExplain()};
				Outer_Table_AdMBTIResult.addRow(qtxt);
				}
		}
		
		//????????? ????????? Dowoo 2021.04.29
		private void MMR_TableClick() {
		int i = inner_table_AdMBTIResult.getSelectedRow();
		String tmMrNum = (String)inner_table_AdMBTIResult.getValueAt(i,0);
		int wkMrNUM = Integer.parseInt(tmMrNum);
		
		MMR_DbAction mmr_DbAction =new MMR_DbAction(wkMrNUM);
		MMR_Bean bean =mmr_DbAction.MMR_TableClick();
		
		tfAdMBTIResultNum.setText(Integer.toString(bean.getMrNum()));
		tfAdMBTIResultType.setText(bean.getMrType());
		tfAdMBTIResultName.setText(bean.getMrName()); 
		tfAdMBTIResultarExplain.setText(bean.getMrExplain());
		
		//Image??????
		String filePath = Integer.toString(data_Enviroment_define.filename);
		
		lbImage.setIcon(new ImageIcon(filePath));
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
		tfFilePath.setText("");
		
		
		}
		
		// ???????????? ??????
		private void MMR_Action(int k) {
			int i_chk = MMR_FieldCheck();
			if(i_chk == 0){
					
				switch(k) {
				case 1 : MMR_insertAction();
					break;
				case 2 : MMR_UpdateAction();
					break;
				case 3 : MMR_DeleteAction();
					break;
				}
				MMR_TableInit();
				MMR_selectList();
				MMR_ClearColumn();
			}else {
				JOptionPane.showMessageDialog(this, "????????????" + "\n" + 
						"Data??? ??????????????? ?????????!");			
				}	
			}
		
			
		//??????????????? Dowoo 2021.04.29
		private void MMR_insertAction(){

			String mrType = tfAdMBTIResultType.getText().trim();
			String mrName = tfAdMBTIResultName.getText().trim();
			String mrExplain = tfAdMBTIResultarExplain.getText().trim();
			
			// Image File
			FileInputStream input = null;
			File file = new File(tfFilePath.getText());
			try {
				input = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			MMR_DbAction mmr_DbAction =new MMR_DbAction(mrType, mrName, mrExplain, input);
			boolean msg = mmr_DbAction.MMR_insertAction();
			
			if(msg=true) {
				JOptionPane.showMessageDialog(this, tfAdMBTIResultName.getText()+" ??? ????????? ?????? ???????????????.!",
			             "?????? ??????!", 
			             JOptionPane.INFORMATION_MESSAGE);  
			}else if(msg=false){
				 
				   JOptionPane.showMessageDialog(this, "DB??? ?????? ????????? ????????? ??????????????????! \n ????????????????????? ???????????????!",
					          "Critical Error!", 
					          JOptionPane.ERROR_MESSAGE);    
			}
		}
		
		//??????	Dowoo 2021.04.29
		private int MMR_FieldCheck(){
			int i = 0;
			if(tfAdMBTIResultType.getText().length() == 0){
				i++;
				tfAdMBTIResultType.requestFocus();
			}
			if(tfAdMBTIResultName.getText().length() == 0){
				i++;
				tfAdMBTIResultName.requestFocus();
			}
			if(tfAdMBTIResultarExplain.getText().length() == 0){
				i++;
				tfAdMBTIResultarExplain.requestFocus();
			}
			return i;
		}
			
		
		
		
		
		//??????	Dowoo 2021.04.29
		private void MMR_UpdateAction() {
			int mrNum = Integer.parseInt(tfAdMBTIResultNum.getText().trim());
			String mrType = tfAdMBTIResultType.getText().trim();
			String mrName = tfAdMBTIResultName.getText().trim();
			String mrExplain = tfAdMBTIResultarExplain.getText().trim();
			
			// Image File
			FileInputStream input = null;
			File file = new File(tfFilePath.getText());
			try {
				input = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MMR_DbAction mmr_DbAction =new MMR_DbAction(mrNum, mrType, mrName, mrExplain, input);
			boolean msg = mmr_DbAction.MMR_UpdateAction();
			
			if(msg=true) {
				JOptionPane.showMessageDialog(this, tfAdMBTIResultName.getText()+" ?????? ????????? ?????????????????????.!",
			             "?????? ??????!", 
			             JOptionPane.INFORMATION_MESSAGE);  
			}else if(msg=false) {
				JOptionPane.showMessageDialog(this, tfAdMBTIResultName.getText()+"DB??? ?????? ????????? ????????? ??????????????????! \n ????????????????????? ???????????????!",
			             "?????? ??????!", 
			             JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		
		//??????
	private void MMR_DeleteAction() {
		
		int mNum  = Integer.parseInt(tfAdMBTIResultNum.getText());
		
		MMR_DbAction mmr_DbAction =new MMR_DbAction(mNum);
		boolean msg=mmr_DbAction.MMR_DeleteAction();
			if(msg=true) {
				JOptionPane.showMessageDialog(this,tfAdMBTIResultName.getText()+"??? ?????????????????????.",
				        	"????????????!",JOptionPane.INFORMATION_MESSAGE);
       
			}else if(msg=false){	 
				JOptionPane.showMessageDialog(this, "DB??? ?????? ????????? ????????? ??????????????????! \n ????????????????????? ???????????????!",
						 "Critical Error!", 
						 JOptionPane.ERROR_MESSAGE);    
			}
		}

	
	// ????????????
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "????????? ???????????? ???????????????!", "??????", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilePath.setText(filePath);
		lbImage.setIcon(new ImageIcon(filePath));
		lbImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	
	
	
}//---------------------------------
