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

package com.ephesoft.dcma.da.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.ephesoft.dcma.core.service.DBScriptExecuter;
import com.ephesoft.dcma.da.dao.PluginDao;

/**
 * This class makes database preparations.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.core.service.DBScriptExecuter
 */
public class DatabasePreperation {

	/**
	 * LOGGER to print the logging information.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(DatabasePreperation.class);

	/**
	 * executer DBScriptExecuter.
	 */
	@Autowired
	private DBScriptExecuter executer;

	/**
	 * pluginDao PluginDao.
	 */
	@Autowired
	private PluginDao pluginDao;

	/**
	 * This method makes some initial settings for database.
	 */
	public void init() {

		LOG.info("==============Running the Database Scripts=======================");
		try {
			if (pluginDao.countAll() != 0) {
				LOG.info("Database is already prepared. Will not execute the DB Scripts.");
				return;
			}
			executer.execute(new ClassPathResource("META-INF/dcma-data-access/init-master-data.sql"));
			executer.execute(new ClassPathResource("META-INF/dcma-data-access/sample-data.sql"));
		} catch (Exception e) {
			LOG.error("Error in execution of Database scripts.", e);
		}
		LOG.info("==============Database Scripts executed successfully==============");
	}

}
