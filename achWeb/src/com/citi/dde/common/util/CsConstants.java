package com.citi.dde.common.util;

/**
 * @author ak99879
 * This class is used for creating generic Constants used through out the application
 * 
 */
public class CsConstants {

	public static final String GI_PAGE_SIZE =	"cs.dda.gipageSize";
	public static final String PARENT_PREFIX =	"CSP";
	public static final String ENTER_KEYVAL	="ENTER";	
	public static final String FULL_WIDTH = "100%";
	public static final String CITI_LOGO_PATH = "images/citi_corp_logo_small.gif";
	
	public static final String CITI_FIRST_NAME ="c_first_name";
	public static final String CITI_COUNTRY_CODE="c_Country";
	public static final String CITI_USER_TYPE="c_UserType";
	
	public static final  String SESSION_LOGINVO = "SESSION_LOGINVO";
	public static final String TIMER_THREAD_REF = "timerThreadRef";
	public static final String SESSION_ID = "sessionId";
	public static final String UNDER_SCORE = "_";
	public static final String SUBMIT_BUTTON = "SUBMIT_BUTTON";
	public static final String SPLITTER = "splitter";
	public static final String HIPHEN = "-";
	public static final String EQUAL = "=";
	public static final String COMMA = ",";
	public static final String COLUMN_PREFIX = "cs.";
	public static final String COLUMN_POSTFIX = ".column";
	public static final String CONTAINS_NUMB_REGEX = ".*\\d+.*";
	public static final String HIDDEN_COL = "hidden_col";
	public static final String KEY_MAP = "key";
	public static final String VALUE_MAP = "value";
	public static final String EMPTY_STRING = "";
	public static final String USER_PREF = "UserPref-";
	public static final String ENVIRONMENT = "environment";
	
	public static final String GRID_COLUMN_NAME = "name";
	public static final String GRID_COLUMN_HIDDEN= "hidden";
	public static final String GRID_COLUMN_WIDTH = "width";
	public static final String GRID_COLUMN_TYPE = "type";
	public static final Object TRUE_STRING = "true";
	public static final Object GRID_COLUMN_SORT = "sort";
	public static final Object GRID_COLUMN_FREEZ = "lastFroze";
	public static final String YES_STRING = "Y";
	public static final String COLUMN = "C";
	public static final Object GRID_COLUMN_HIDABLE = "columnHidable";
	public static final String DEFAULT_TYPE = "java.lang.String";
	public static final Double DEFAULT_WIDTH = 100.0;
	public static final String DEFAULT_NAME = "DEFINE COLUMN NAME";
	public static final boolean DEFAULT_FLAG = false;
	public static final Object GRID_COLUMN_MANDATE = "mandate";
	public static final String ASTERISK = "*";
	public static final String DDA_TXN_BILLER = "CSC2DDABMAINT";
	public static final String RRO = "RRO";
	public static final String AUTH = "Authorise";
	public static final String GIHIT = "GI Hit";
	public static final String RJCTD = "Rejected";
	public static final String EXCEL_TYPE = ".xls";
	public static final String DDA_TXN_PAYER = "CSC2DDAPMAINT";
	public static final String DDA_MAINT_BILLER_FILE_NAME = "DDA Maintenance Biller";
	public static final String GET = "get";
	public static final String GRID_COLUMN_INVALID = "inValidColumn";
	public static final String GRID_COLUMN_PROPERTY = "property";
	public static final String PROP_MAP = "prop";
	public static final String BILLER_ID = "biller";
	public static final String PAYER_ID="payer";
	public static final String VALUE_PROP_MAP = "valueProp";
	public static final String SET = "set";
	public static final String HASH = "#";
	public static final String CHAPS_PACKAGE_ENTITY = "com.citi.dda.entities";
	public static final String GRID_COLUMN_EDIATBLE = "editable";
	public static final boolean DEFAULT_EDITABLE_FLAG = true;
	public static final String NO_STRING = "N";
	public static final String GRID_COLUMN_SIZE = "size";
	public static final String MAKER_ADD="cs.ddaMaintenance.makerAdd";
	public static final String MAKER_MODIFY="cs.ddaMaintenance.makerModify";
	public static final String MAKER_DELETE="cs.ddaMaintenance.makerDelete";
	public static final String CHECKER_AUTHORISE="501";
	public static final String CHECKER_REJECT="502";
	public static final String CHECKER_DELETED = "510";
	public static final String CKR = "CKR";
	public static final String CHECKER_ROLE = "C";
	public static final String MAKER_ROLE = "M";
	public static final String AUTH_BTN = "cs.chaps.authorise.button";
	public static final String SAVE_BTN = "cs.chaps.save.button";
	public static final String CLOSE_BTN = "cs.chaps.close.button";
	public static final String AUDIT_BTN = "cs.chaps.audit.button";
	public static final String DELETE_BTN ="cs.chaps.delete.button";
	public static final String REJECT_BTN ="cs.chaps.reject.button";
	public static final String OVERRIDE_BTN ="cs.chaps.override.button";
	public static final String EXCEL_BTN ="cs.chaps.excel.button";
	
	public static final String GI_BTN ="cs.chaps.gi.button";
	public static final String GI_OVERRIDE_BTN ="cs.chaps.giOverrid.button";
	public static final String GI_REJECT_BTN ="cs.chaps.giReject.button";
	public static final String ADD_BTN = "cs.chaps.add.button";
	public static final String VIEWER_ROLE = "V";
	public static final String DUAL_ROLE = "D";
	public static final String VALIDATE_USER_MSG = "cs.chaps.dda.validateUser";
	public static final String EMPTY_AUTH_LIST_MSG = "cs.chaps.dda.noChangesToAuth";

	public static final String TEXT_FIELD = "TEXT_FIELD";
	public static final String NUMBER = "NUMBER";
	public static final int DFLT_LENGTH = 120;

	public static final String SDF = "dd-MMM-yy";
	public static final String ACTIVE_READY = "Ready for Active";
	public static final String INACTIVE = "Inactive";
	public static final String ACTIVE = "Active";
	public static final String REJECT_READY = "Ready for Reject";
	public static final String TERMINATE_READY = "Ready for Terminate";
	public static final String ACTIVE_READY_CODE = "1111";
	//public static final String ACTIVE_CODE = "2222";
	public static final String REJECT_READY_CODE = "3333";
	public static final String TERMINATE_READY_CODE = "4444";
	public static final String MARKED_ACTIVE_CODE = "5555";
	public static final String MARKED_INACTIVE_CODE = "6666";
	public static final String MARKED_TERMINATE_CODE = "7777";
	public static final Object MARKED_REJECT_CODE = "8888";
	public static final Object PPM_TERMINATE_CODE = "9011";
	public static final Object PPM_ACTIVE_CODE = "9022";
	public static final Object PPM_REJECT_CODE = "9033";
	
	public static final String MARKED_REJECT = "Marked Reject";
	public static final String MARKED_ACTIVE ="Marked Active";
	public static final String MARKED_TERMINATE = "Maked Terminate";
	public static final String MARKED_INACTIVE = "Marked Inactive";
	public static final String ACTIVE_READY_PROP = "cs.ddaMaintActivation.activeReadyCodeListPayer";
	public static final String TERMINATE_READY_PROP = "cs.ddaMaintActivation.terminateReadyCodeListPayer";
	public static final String REJECT_READY_PROP = "cs.ddaMaintActivation.rejectReadyCodeListPayer";
	//public static final String ACTIVE_PROP = "cs.ddaMaintActivation.isActiveCodePayer";
	public static final String APPL_ID = "apl_id";
	public static final String AUTH_PAYER_STATUSCD = "statuscdP";
	//Activation LastAction code start
	public static final String MANDATE_MARKED_ACTIVE_ACTION = "900";
	public static final String MANDATE_MARKED_ACTIVE_AUTH_ACTION = "910";
	public static final String MANDATE_MARKED_ACTIVE_REJECT_ACTION = "905";
	public static final String MANDATE_MARKED_TERMINATE_ACTION = "920";
	public static final String MANDATE_MARKED_TERMINATE_AUTH_ACTION = "930";
	public static final String MANDATE_MARKED_TERMINATE_REJECT_ACTION = "925";
	public static final String MANDATE_MARKED_REJECT_ACTION = "940";
	public static final String MANDATE_MARKED_REJECT_AUTH_ACTION = "940";
	public static final String MANDATE_MARKED_REJECT_REJECT_ACTION = "940";
	//Activation LastAction code end
	public static final String MARKED_REJECT_STATUSCD = "cs.ddaMaintActivation.markedReject";
	public static final String MARKED_TERMINATE_STATUSCD = "cs.ddaMaintActivation.markedTerminate";
	public static final String MARKED_ACTIVE_NEW_STATUSCD = "cs.ddaMaintActivation.markedActiveNew";
	public static final String MARKED_ACTIVE_MODIFY_STATUSCD = "cs.ddaMaintActivation.markedActiveModify";
	public static final String AUTH_MODIFY_STATUSCD = "cs.ddaMaintenance.authModify";
	public static final String AUTH_CREATE_STATUSCD = "cs.ddaMaintenance.authCreate";
	public static final String AUTH_CREATE_REG_STATUSCD = "cs.ddaMaintenance.authCreateReg";
	public static final String AUTH_DELETE_STATUSCD = "cs.ddaMaintenance.authDelete";
	public static final String AUTH_ACTIVE_NEW_STATUSCD = "cs.ddaMaintActivation.authActiveNew";
	public static final String AUTH_ACTIVE_MODIFY_STATUSCD = "cs.ddaMaintActivation.authActiveModify";
	public static final String AUTH_REJECT_STATUSCD = "cs.ddaMaintActivation.authReject";
	public static final String AUTH_TERMINATE_STATUSCD = "cs.ddaMaintActivation.authTerminate";
	public static final String BILLER_ID_LIST = "billerRefIdList";
	public static final String PAGE_TEMPLATE = "%d of %d";
	public static final String SAVE_SIZE = "saveSize";
	public static final String D_STRING = "D";
	public static final String PAGE_SIZE="cs.chaps.pageSize";
	public static final String MANDATORY_MSG="cs.chaps.dda.mandatory";
	//public static final String DFLT_FREQ="Frequency";
	public static final String DDA_ACT_CHECEKR_TITLE = "CSC2DDAACTVCKR";
	public static final String DDA_ACT_TITLE = "CSC2DDAACTV";
	public static final String DDA_MAINT_CHECEKR_TITLE = "CSC2DDABSCRCKR";
	public static final String DDA_MAINT_TITLE = "CSC2DDABSCR";
	public static final String SEARCH_CRIT_LABEL = "cs.dda.searchCriteria.label";
	public static final String MANDATE_DETAILS_LABEL = "cs.dda.mandateDetails.label";
	public static final String AUDIT_MANDATE_LABEL = "cs.dda.auditMandateDetails.label";
	public static final String CHECKER = "- CHECKER";
	public static final String MAKER = "- MAKER";
	public static final String VIEWER = "- VIEWER";
	public static final String SCREEN_LABEL = "SCREEN_LABEL";
	public static final String PROCESSING_CAPTION = "cs.chaps.processing.caption";
	public static final String PPM_RECORDS = "PPM-Processing";
	public static final String ISEXCEL = "isExcel";
	public static final String PPM_STATUS_CODES = "cs.ddaMaintenance.ppm.statusCD";
	public static final String PPM_ACT_STATUS_CODES = "cs.ddaMaintenance.ppm.statusCD";
	public static final String PPM_ACTIVE_SENT = "PPM Active Sent";
	public static final String PPM_TERMINATE_SENT = "PPM Terminate Sent";
	public static final String PPM_REJECT_SENT = "PPM Reject Sent";
	public static final String PPM_ACTIVE_STATUSCD = "cs.ddaMaintActivation.ppmActive.statusCD";
	public static final String PPM_TERMINATE_STATUSCD = "cs.ddaMaintActivation.ppmTerminat.statusCD";
	public static final String PPM_REJECT_STATUSCD = "cs.ddaMaintActivation.ppmReject.statusCD";
	public static final String PPM_ALL = "All";
	public static final String PPM_ACTIVATION_ALL_STATUSCD = "cs.ddaMaintActivation.ppm.statusCD";
	public static final String LOGOFF ="CSC1LOGOFF";
	public static final String CHAPS_SDF ="cs.chaps.dateFormat" ;
//	public static final String FREQUENCY_MAP = "frequncyMap";
	public static final String DDA_MAINT_DFLT_AUTH_STATUSCD="cs.ddaMaintenance.dflt.auth";
	public static final String DDA_MAINT_DFLT_RRO_STATUSCD="cs.ddaMaintenance.dflt.rro";
	public static final String DDA_MAINT_DFLT_RJCTD_STATUSCD="cs.ddaMaintenance.dflt.rjctd";
	
	public static final String DDA_ACTIVE_DFLT_AUTH_STATUSCD="cs.ddaMaintActivation.dflt.auth";
	public static final String DDA_ACTIVE_DFLT_RRO_STATUSCD="cs.ddaMaintActivation.dflt.rro";
	public static final String DEPOSIT_CHANNEL = "DEPOSIT_CHANNEL";
	public static final String BUSINESS_DATE = "BUSINESS_DATE";
	public static final String DDA_MAINT = "DDA_MAINT";
	public static final String MARKED_ACTIVE_STATUSCD = "cs.ddaMaintActivation.markedActive";
	public static final String STATUS_TO_DELETE = "cs.ddaMaintenance.todelete";
	public static final String GAIN_LOCK_ACCESS_MAINT = "M";
//	public static final String GAIN_LOCK_ACCESS_ACTV = "A";
	public static final String SESSION_TIME = "cs.chaps.session.inMilliSeconds";
	public static final String PROCESSED_STATUS_MAINTENANCED = "M";
//	public static final String PROCESSED_STATUS_ACTIVE = "A";
	public static final String CHECKER_DELETE_AUTH = "cs.ddaMkrChkr.checkerDeleteAuth";
	public static final String CHECKER_REJECT_AUTH = "cs.ddaMkrChkr.checkerRejectAuth";
	public static final String AUTH_MODIFY_REG_STATUSCD = "cs.ddaMaintenance.authModifReg";
	public static final String NON_EDITABLE = "cs.ddaMaintenance.noneditable";
	public static final String DEFAULT_TERMINATE = "cs.ddaMaintActivation.default.terminate";
	public static final String TOTAL="Total";
	public static final String SUCCESS="Success";
	public static final String FAIL="Fail";
	public static final String PENDING="Pending";
	public static final String DUPLICATE="Duplicate";
	public static final String DDA_MAINT_PPM_QUERY = "cs.ddaMaintenance.ppmStatus.query";
	public static final String DDA_MAINT_PPM_ODERBY = "cs.ddaMaintenance.ppmStatus.query.orderBy";
	public static final String DDA_MAINT_PPM_FIELD_COL_LIST = "cs.ddaMaintenance.ppmStatus.query.fieldValue";
	public static final String DDA_ACTIVE_PPM_QUERY = "cs.ddaMaintActivation.ppmStatus.query";
	public static final String DDA_ACTIVE_PPM_ODERBY = "cs.ddaMaintActivation.ppmStatus.query.orderBy";
	public static final String SYSTEM_EOD = "SYSTEM_EOD";
	public static final String SYSTEM_BOD = "SYSTEM_BOD";
	
	public static final String EOD_BOD_MESSAGE = "EODMESSAGE";
	
	public static final String NO_CHANGES_SAVE ="cs.chaps.no.change";
	public static final String MANDATE_NEW_PAID ="cs.ddaMaintMandate.newPaid";
	public static final String MANDATE_MODIFY_PAID ="cs.ddaMaintMandate.modifiedPaid";
	public static final String DUPLICATE_MANDATE_RRO = "DUPLICATE_RRO";
	public static final String DUPLICATE_MANDATE_MAIN = "DUPLICATE_MAIN";
	public static final String UNIQUE_MANDATE = "NEW_MANDATE";
//	public static final String LOCK_FOR_BANK_OR_BRANCH_CODE_UPDATE = "O";
	public static final String MESSAGE_FOR_BANK_OR_BRANCH_CODE_UPDATE="cs.chaps.bankBranchCodeUpdate";
	
	public static final String CURRENCY="dfp.currency";
	public static final String IDD_FLEX_BRANCH_CHECK = "cs.chaps.maint.flexbrnchCd.select";
    public static final String APPEND_CUST_BASE_CHAR = "dfp.dda.iddMandate.custBaseChar";
	public static final String COUNTRY_CODE = "dfp.dda.countryCode";
	public static final String BUSINESS_GROUP = "BUSINESS_GRP";
	public static final String CUST_RESI_STATUS = "CUST_RESI_STATUS";
	public static final String CUST_TYPE = "CUST_TYPE";
	public static final String TXN_PURPOSE = "TXN_PURPOSE";
	public static final String DDE_PLUS_LABEL ="dda.dfp.label";
    public static final String DDE_PLUS_URL ="dda.dfp.url"; 

	public static final String SDN_Y_GI_CHECK = "Y";
	public static final String SDN_N_GI_CHECK = "N";
	public static final String SDN_Y_GI_OVERR = "O";
	public static final String SDN_Y_GI_RJCT = "R";
	public static final String MAKER_RJCT_ACT = "R";
	public static final String MAKER_OVER_ACT = "O";
	public static final String CHECKER_AUTH_ACT = "A";
	public static final String CHECKER_RJCT_ACT = "R";
    public static final String PENDING_GI_CHECK = "P";
	public static final String GI_OVERRIDE="GI_OVERRIDE";
	public static final String GI_PENDING="GI_PENDING";
	public static final String GI_REJECT="GI_REJECT";
	public static final String GAIN_LOCK_ACCESS_FILE = "F";
	public static final Integer GI_OVERRIDE_STATUSCD = 1100;
	public static final Integer GI_REJECT_STATUSCD = 1200;
	public static final Integer MKR_OVERRIDE_STATUSCD =1600;
	public static final Integer MKR_REJECT_STATUSCD=1700;
	public static final Integer CKR_REJECT_STATUSCD=1800;
	public static final String COLON = ":";
	public static final String urlPrefix="jdbc:oracle:thin:@";
	public static final String UPDATE_MANDATE = "EXISTING_MANDATE";
	public static final String REJECT_NOT_ALLOWED = "dfp.dda.rjct.notallowed";
	public static final String DB_USER_NAME = "db.user";
	public static final String DB_SID = "HOSTSTRING";
	public static final String DB_PORT = "SERVERPORT";
	public static final String DB_HOST = "HOST";
	public static final String DB_SCRIPT_PATH = "pwp.scriptpath";
	public static final String SESSION_TIMEOUT = "dda.ideal.sessionTime";
	public static final String BACK_TO_DFP = "BACK_TO_DFP";
	public static final String INVALID_USER_ACCESS ="cs.dfp.invalidUserAccess";
	public static final String USER_SERVICE = "ULS";
	public static final String USER_LOGOUT_QRY = "UPDATE DFP_TB_USER_LOG SET IS_ACTIVE = 'N' , LOGOFF_TIME =? WHERE USER_NAME =? and SESSION_ID =?";
	public static final Object JSON_USER_INFO_FAIL_MSG = "JSON extraction failed from SM User details";
	public static final String COUNTRY = "ID";
}
