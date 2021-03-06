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

package com.ephesoft.dcma.gwt.home.client;

import com.ephesoft.dcma.gwt.core.client.AbstractController;
import com.ephesoft.dcma.gwt.home.client.presenter.BatchListPresenter;
import com.ephesoft.dcma.gwt.home.client.view.LandingView;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Composite;

/**
 * This class provides functionality to control batch list view, save, update etc.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.gwt.admin.bm.client.AbstractController
 */
public class BatchListController extends AbstractController {

	/**
	 * batchListPresenter BatchListPresenter.
	 */
	private BatchListPresenter batchListPresenter;

	/**
	 * view LandingView.
	 */
	private LandingView view;

	/**
	 * Constructor.
	 * 
	 * @param eventBus HandlerManager
	 * @param rpcService TableModelServiceAsync
	 */
	public BatchListController(HandlerManager eventBus, TableModelServiceAsync rpcService) {
		super(eventBus, rpcService);
	}

	/**
	 * To get presenter.
	 * 
	 * @return BatchListPresenter
	 */
	public BatchListPresenter getPresenter() {
		return batchListPresenter;
	}

	/**
	 * To get view.
	 * 
	 * @return LandingView
	 */
	public LandingView getView() {
		return view;
	}

	/**
	 * To create View.
	 * 
	 * @return Composite
	 */
	@Override
	public Composite createView() {
		this.view = new LandingView();
		this.view.buildLandingPage();
		this.batchListPresenter = new BatchListPresenter(this, view);
		return this.view;
	}

	/**
	 * To handle events.
	 * 
	 * @param eventBus HandlerManager
	 */
	@Override
	public void injectEvents(HandlerManager eventBus) {
		// TODO Auto-generated method stub

	}

	/**
	 * To refresh.
	 */
	@Override
	public void refresh() {
		// TODO Auto-generated method stub

	}

	/**
	 * To get Rpc Service.
	 * 
	 * @return TableModelServiceAsync
	 */
	@Override
	public TableModelServiceAsync getRpcService() {
		return (TableModelServiceAsync) super.getRpcService();
	}
}
