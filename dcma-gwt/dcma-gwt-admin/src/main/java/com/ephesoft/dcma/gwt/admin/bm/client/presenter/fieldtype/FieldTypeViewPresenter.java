/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2010-2012 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.gwt.admin.bm.client.presenter.fieldtype;

import java.util.List;

import com.ephesoft.dcma.gwt.admin.bm.client.BatchClassManagementController;
import com.ephesoft.dcma.gwt.admin.bm.client.MessageConstants;
import com.ephesoft.dcma.gwt.admin.bm.client.i18n.BatchClassManagementMessages;
import com.ephesoft.dcma.gwt.admin.bm.client.presenter.AbstractBatchClassPresenter;
import com.ephesoft.dcma.gwt.admin.bm.client.view.fieldtype.FieldTypeView;
import com.ephesoft.dcma.gwt.admin.bm.client.view.fieldtype.KVExtractionTestResultView;
import com.ephesoft.dcma.gwt.core.client.EphesoftAsyncCallback;
import com.ephesoft.dcma.gwt.core.client.RandomIdGenerator;
import com.ephesoft.dcma.gwt.core.client.i18n.LocaleDictionary;
import com.ephesoft.dcma.gwt.core.client.ui.ScreenMaskUtility;
import com.ephesoft.dcma.gwt.core.shared.AdvancedKVExtractionDTO;
import com.ephesoft.dcma.gwt.core.shared.ConfirmationDialog;
import com.ephesoft.dcma.gwt.core.shared.ConfirmationDialogUtil;
import com.ephesoft.dcma.gwt.core.shared.KVExtractionDTO;
import com.ephesoft.dcma.gwt.core.shared.OutputDataCarrierDTO;
import com.ephesoft.dcma.gwt.core.shared.RegexDTO;
import com.ephesoft.dcma.gwt.core.shared.ConfirmationDialog.DialogListener;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.DialogBox;

/**
 * The presenter for view that shows the field type view details.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.gwt.admin.bm.client.presenter.AbstractBatchClassPresenter
 */
public class FieldTypeViewPresenter extends AbstractBatchClassPresenter<FieldTypeView> {

	/**
	 * KV_EXTRACTION_RESULT String.
	 */
	private static final String KV_EXTRACTION_RESULT = "KV Extraction Result";

	/**
	 * fieldTypeDetailPresenter FieldTypeDetailPresenter.
	 */
	private final FieldTypeDetailPresenter fieldTypeDetailPresenter;

	/**
	 * editFieldTypePresenter EditFieldTypePresenter.
	 */
	private final EditFieldTypePresenter editFieldTypePresenter;

	/**
	 * kvExtractionTestResultView KVExtractionTestResultView.
	 */
	private final KVExtractionTestResultView kvExtractionTestResultView;

	/**
	 * Constructor.
	 * 
	 * @param controller BatchClassManagementController
	 * @param view FieldTypeView
	 */
	public FieldTypeViewPresenter(BatchClassManagementController controller, FieldTypeView view) {

		super(controller, view);
		this.fieldTypeDetailPresenter = new FieldTypeDetailPresenter(controller, view.getFieldTypeDetailView());
		this.editFieldTypePresenter = new EditFieldTypePresenter(controller, view.getEditFieldTypeView());
		this.kvExtractionTestResultView = new KVExtractionTestResultView();
	}

	/**
	 * Processing to be done on load of this presenter.
	 */
	@Override
	public void bind() {
		fieldTypeDetailPresenter.bind();
		if (controller.getSelectedDocumentLevelField() != null) {
			view.createKVFieldList(controller.getSelectedDocumentLevelField().getKvExtractionList());
			view.createRegexList(controller.getSelectedDocumentLevelField().getRegexList());
		}
		editFieldTypePresenter.bind();
	}

	/**
	 * To show Field Type View.
	 */
	public void showFieldTypeView() {
		view.getFieldTypeVerticalPanel().setVisible(Boolean.TRUE);
		view.getFieldTypeConfigVerticalPanel().setVisible(Boolean.FALSE);
	}

	/**
	 * To show edit Field Type View.
	 */
	public void showEditFieldTypeView() {
		view.getFieldTypeVerticalPanel().setVisible(Boolean.FALSE);
		view.getFieldTypeConfigVerticalPanel().setVisible(Boolean.TRUE);
	}

	/**
	 * To perform operations when add KV button is clicked.
	 */
	public void onAddKVButtonClicked() {
		if (controller.isAdd()) {
			ConfirmationDialogUtil.showConfirmationDialogError(LocaleDictionary.get().getMessageValue(
					BatchClassManagementMessages.ADD_FIELD_TYPE));
			return;
		}
		KVExtractionDTO kvExtractionDTO = createKVExtractionDTOObject();

		controller.setAdd(true);
		controller.setSelectedKVExtraction(kvExtractionDTO);
		controller.getMainPresenter().showKVExtractionView(true);
	}

	/**
	 * To create KV Extraction DTO Object.
	 * 
	 * @return KVExtractionDTO
	 */
	public KVExtractionDTO createKVExtractionDTOObject() {
		KVExtractionDTO kvExtractionDTO = new KVExtractionDTO();
		kvExtractionDTO.setNew(true);
		kvExtractionDTO.setFieldTypeDTO(controller.getSelectedDocumentLevelField());
		kvExtractionDTO.setIdentifier(String.valueOf(RandomIdGenerator.getIdentifier()));
		return kvExtractionDTO;
	}

	/**
	 * To perform operations when test KV button is clicked.
	 * 
	 * @param identifier String
	 */
	public void onTestKVButtonClicked(String identifier) {
		ScreenMaskUtility.maskScreen();
		controller.setSelectedKVExtraction(controller.getSelectedDocumentLevelField().getKVExtractionDTOByIdentifier(identifier));
		controller.getRpcService().testKVExtraction(controller.getBatchClass(), controller.getSelectedKVExtraction(), null, false,
				new EphesoftAsyncCallback<List<OutputDataCarrierDTO>>() {

					@Override
					public void customFailure(Throwable throwable) {
						ScreenMaskUtility.unmaskScreen();
						final ConfirmationDialog dialog = ConfirmationDialogUtil.showConfirmationDialog(throwable.getMessage(),
								MessageConstants.TITLE_TEST_FAILURE, Boolean.TRUE);
						dialog.addDialogListener(new DialogListener() {

							@Override
							public void onOkClick() {
								dialog.hide(true);
							}

							@Override
							public void onCancelClick() {
								// TODO Auto-generated method stub
							}
						});

					}

					@Override
					public void onSuccess(List<OutputDataCarrierDTO> outputDtos) {
						ScreenMaskUtility.unmaskScreen();
						DialogBox dialogBox = new DialogBox();
						dialogBox.addStyleName("width500px");
						dialogBox.setHeight("200px");
						kvExtractionTestResultView.createKVFieldList(outputDtos);
						kvExtractionTestResultView.setDialogBox(dialogBox);
						dialogBox.setText(KV_EXTRACTION_RESULT);
						dialogBox.setWidget(kvExtractionTestResultView);
						dialogBox.center();
						kvExtractionTestResultView.getBackButton().setFocus(true);
						dialogBox.show();
					}
				});
	}

	/**
	 * To perform operations when edit field properties button is clicked.
	 */
	public void onEditFieldPropertiesButtonClicked() {
		controller.setAdd(false);
		showEditFieldTypeView();
		controller.getBatchClass().setDirty(Boolean.TRUE);
		editFieldTypePresenter.bind();
	}

	/**
	 * To perform operations when edit field properties button is clicked.
	 * 
	 * @param identifier String
	 */
	public void onEditKVButtonClicked(String identifier) {
		KVExtractionDTO kvExtractionDTO = controller.getSelectedDocumentLevelField().getKVExtractionDTOByIdentifier(identifier);
		if (!kvExtractionDTO.isSimpleKVExtraction()) {
			view.getConformationForKVExtractionView(false, kvExtractionDTO);
		} else {
			showSimpleKVExtractionView(kvExtractionDTO);
		}
	}

	/**
	 * To show Simple KV Extraction View.
	 * 
	 * @param kvExtractionDTO KVExtractionDTO
	 */
	public void showSimpleKVExtractionView(KVExtractionDTO kvExtractionDTO) {
		controller.setSelectedKVExtraction(kvExtractionDTO);
		controller.setAdd(false);
		controller.getMainPresenter().showKVExtractionView(false);
	}

	/**
	 * To perform operations when delete KV button is clicked.
	 * 
	 * @param identifier String
	 */
	public void onDeleteKVButtonClicked(String identifier) {
		controller.getSelectedDocumentLevelField().getKVExtractionDTOByIdentifier(identifier).setDeleted(true);
		controller.getBatchClass().setDirty(true);
		controller.getMainPresenter().showFieldTypeView(false);

	}

	/**
	 * To perform operations when delete Regex button is clicked.
	 * 
	 * @param identifier String
	 */
	public void onDeleteRegexBtnClicked(String identifier) {
		controller.getSelectedDocumentLevelField().getRegexDTOByIdentifier(identifier).setDeleted(true);
		controller.getBatchClass().setDirty(true);
		controller.getMainPresenter().showFieldTypeView(false);
	}

	/**
	 * To perform operations when edit Regex button is clicked.
	 * 
	 * @param identifier String
	 */
	public void onEditRegexButtonClicked(String identifier) {
		controller.setSelectedRegex(controller.getSelectedDocumentLevelField().getRegexDTOByIdentifier(identifier));
		controller.setAdd(false);
		controller.getMainPresenter().showRegexView(false);
	}

	/**
	 * To perform operations when add Regex button is clicked.
	 */
	public void onAddRegexBtnClicked() {
		if (controller.isAdd()) {
			ConfirmationDialogUtil.showConfirmationDialogError(LocaleDictionary.get().getMessageValue(
					BatchClassManagementMessages.ADD_FIELD_TYPE));
			return;
		}
		RegexDTO regexDTO = createRegexDTOObject();
		controller.setAdd(true);
		controller.setSelectedRegex(regexDTO);
		controller.getMainPresenter().showRegexView(true);
	}

	/**
	 * To create Regex DTO Object.
	 * 
	 * @return RegexDTO
	 */
	public RegexDTO createRegexDTOObject() {
		RegexDTO regexDTO = new RegexDTO();
		regexDTO.setNew(true);
		regexDTO.setFieldTypeDTO(controller.getSelectedDocumentLevelField());
		regexDTO.setIdentifier(String.valueOf(RandomIdGenerator.getIdentifier()));
		return regexDTO;
	}

	/**
	 * To handle events.
	 * 
	 * @param eventBus HandlerManager
	 */
	@Override
	public void injectEvents(HandlerManager eventBus) {
		// Event handling is done here.
	}

	/**
	 * To perform operations when advanced KV add button is clicked.
	 */
	public void onAdvancedKVAddButton() {
		if (controller.isAdd()) {
			ConfirmationDialogUtil.showConfirmationDialogError(LocaleDictionary.get().getMessageValue(
					BatchClassManagementMessages.ADD_FIELD_TYPE));
			return;
		}
		KVExtractionDTO kvExtractionDTO = createKVExtractionDTOObject();
		AdvancedKVExtractionDTO advancedKVExtractionDTO = new AdvancedKVExtractionDTO();
		kvExtractionDTO.setAdvancedKVExtractionDTO(advancedKVExtractionDTO);
		controller.setAdd(true);
		controller.setSelectedKVExtraction(kvExtractionDTO);
		controller.getMainPresenter().showAdvancedKVExtractionView();
		controller.getMainPresenter().getAdvancedKVExtractionPresenter().setEditAdvancedKV(false);
	}

	/**
	 * To perform operations when advanced KV edit button is clicked.
	 * 
	 * @param identifier String
	 */
	public void onAdvancedEditKVButtonClicked(String identifier) {
		KVExtractionDTO kvExtractionDTO = controller.getSelectedDocumentLevelField().getKVExtractionDTOByIdentifier(identifier);

		controller.getMainPresenter().getAdvancedKVExtractionPresenter().setEditAdvancedKV(true);
		if (kvExtractionDTO.isSimpleKVExtraction()) {
			view.getConformationForKVExtractionView(true, kvExtractionDTO);
		} else {
			showAdvancedKVExtractionView(identifier);
		}
	}

	/**
	 * To show Advanced KV Extraction View.
	 * 
	 * @param identifier String
	 */
	public void showAdvancedKVExtractionView(String identifier) {

		controller.setSelectedKVExtraction(controller.getSelectedDocumentLevelField().getKVExtractionDTOByIdentifier(identifier));
		controller.setAdd(false);
		controller.getBatchClass().setDirty(Boolean.TRUE);
		controller.getMainPresenter().showAdvancedKVExtractionView();


	}
}
