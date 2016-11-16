package com.seal.www.edusch_login.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class C2SNotifyImpl implements IC2SNotify {

	private static final String TAG = C2SNotifyImpl.class.getSimpleName();
	Map<String, Object> params = new HashMap<String, Object>();
	private Message message;
	private String tag = "MYDEBUG";
	private Intent intent;
	private Bundle bundle;
	private Handler mHandler;
	private boolean isAlreadyGetDomain = false;
	private static long ulCurNetState = 1;

	public static long getUlCurNetState() {
		return ulCurNetState;
	}

	public boolean getAlreadyGetDomain() {
		return isAlreadyGetDomain;
	}

	public void setAlreadyGetDomain(boolean isAlreadyGetDomain) {
		this.isAlreadyGetDomain = isAlreadyGetDomain;
	}

	public C2SNotifyImpl(Handler handler) {
		mHandler = handler;
	}

	public C2SNotifyImpl() {
	}

	public void setHandler(Handler handler) {
		mHandler = handler;
	}


	@Override
	public void OnSearchFriendEnd() {

	}

	@Override
	public void OnRawMessage(long msgid, long param, long context) {

	}

	@Override
	public void OnConnected() {
		Log.i("SEAL","OnConnected=======================");
	}

	@Override
	public void OnReconnect(long ulError) { // 1.表示重连失败 0.成功
	}

	/**
	 * error 0--断开连接，3--表示新版本，1--登陆失败，2--异地登陆
	 */
	@Override
	public void OnDisconnected(int error) {
	}

	@Override
	public void OnMemberLogin(short usErrCode, long ulMemberID) {
		Log.i("SEAL","OnMemberLogin===========================");
	}
	private void OnClientNetStatusChanged(int clientState, boolean bIsReconnect) {
		// 网络状态改变
	}

	/**
	 * 函数名：OnCurNetState 检查当前网络连接状态 参数:ulCurNetState--当前网络连接状态 0--正在连接，1--已连接上
	 */
	@Override
	public synchronized void OnCurNetState(long ulCurNetState) {
	}

	@Override
	public void OnSetHostMan(long ulMemberID, long ulMeetingID) {

	}

	@Override
	public void OnShowErrorMessage(long nErrorCode) {

	}

	@Override
	public void OnFetchBulletin(Object messageBean) {

	}

	@Override
	public void OnNewSysMsg(long ulSysMsgID) {

	}

	@Override
	public void OnCallMeetingNum(Object meetingBaseItem, String strMeetingNum, int nRet) {

	}




	@Override
	public void OnDeleteMeetingRoom(short usErrCode, long ulMeetingID) {

	}

	/**
	 * 创建者踢人的时候或者自行离开，参与者收到此回调 被踢者收到OnKickOutMeetingMember回调
	 */
	@Override
	public void OnDeleteMeetingMember(short usErrCode, long ulMeetingID, long ulMemberID) {
	}

	@Override
	public void OnGetMeetingBaseItem(Object oMeetingBase) {

	}

	@Override
	public void OnGetMeetingMemberBaseItem(Object oMemberBaseItem) {

	}

	@Override
	public void OnApplyJoinMeeting(short usErrCode, long ulMeetingID, long ulMemberID, String strNickName) {

	}

	@Override
	public void OnAcceptJoinMeeting(long ulMeetingID, long ulMemberID) {

	}

	@Override
	public void OnRejectJoinMeeting(long ulMeetingID, long ulMemberID, long ulError) {

	}

	@Override
	public void OnSelfJoinMeetingRoom(short usErrCode, long ulMeetingID) {

	}

	@Override
	public void OnOtherJoinMeetingRoom(short usErrCode, long uMemberid, long ulMeetingID) {

	}

	@Override
	public void Meeting_InviteUserJoinMeeting(long ulMeetingID, long ulUserID) {

	}

	@Override
	public void OnIEMMeetingInvite(long ulMeetingID, long ulUserID, long mType, String strNickName) {

	}

	@Override
	public void OnReceivedMeetingData(long uMemberid, Object rCmdPacket) {

	}

	@Override
	public void OnShowMessage(String str) {

	}

	@Override
	public void OnExitMeeting() {

	}

	@Override
	public void UpdateMeetingMemberStatus(long ulMeetingID, long ulMemberID, char ucStatus) {

	}

	@Override
	public void UpdateMeetingStatus(long ulMeetingID, char ucStatus) {

	}

	@Override
	public void OnGetUserInfo(Object userInfo, int nDomainID) {

	}

	@Override
	public void OnDepartItem(Object departItem) {

	}

	@Override
	public void OnDepartMemberItem(Object departMemberItem) {

	}

	@Override
	public void OnUserListItem(Object userItem) {

	}

	@Override
	public void OnFetchAllUserEnd() {

	}

	@Override
	public void OnFriendItem(Object userItem) {

	}

	@Override
	public void OnFetchAllFriendEnd() {

	}

	@Override
	public void OnSearchFriend(Object userItem) {

	}

	@Override
	public void OnAddFriend(Object userItem) {

	}

	@Override
	public void OnDeleteFriend(long ulUserID) {

	}

	@Override
	public void OnGroupItem(Object groupItem) {

	}

	@Override
	public void OnAddGroup(Object groupItem) {

	}

	@Override
	public void OnDeleteGroup(long ulGroupID) {

	}

	@Override
	public void OnGroupMemberItem(Object GroupMemberItem) {

	}

	@Override
	public void OnAddGroupMember(Object groupMemberItem) {

	}

	@Override
	public void OnDeleteGroupMember(long ulUserID, long ulGroupID) {

	}

	@Override
	public void OnFetchAllGroupMemberEnd(String type) {

	}

	@Override
	public void OnDomainItem(String strDomain) {

	}

	@Override
	public void OnFetchDomainEnd() {

	}

	@Override
	public void OnRegisiterUser(int ret) {

	}

	@Override
	public void OnModifyGroup(Object groupinfos) {

	}

	@Override
	public void OnMobileNOCheck(Object userInfo) {

	}

	@Override
	public void OnRoomMeetingCreateOver(Object meetingBaseItem) {

	}

	@Override
	public void OnMeetingMemberInfo(long ulMeetingID, long ulMemberID, String strmemberName, int nTheLastMember) {

	}

	@Override
	public void OnModifyMeeting(int usErrCode, long ulMemberID, Object meetingBaseItem) {

	}

	@Override
	public void OnHeldMeetingBaseItem(Object meetingBaseItem) {

	}

	@Override
	public void OnKickOutMeetingMember(long ulMeetingID, long ulMemberID) {

	}

	@Override
	public void OnEndMeeting(long ulMeetingID) {

	}

	@Override
	public void OnMeetingBaseItem(Object pMeetingBaseItem, long ulIntervalTime) {

	}

	@Override
	public void OnMemberBaseItem(Object pMemberBaseItem) {

	}

	@Override
	public void OnAddMeetingMember(long ulErrCode, long ulMeetingID, long ulMemberID) {

	}

	@Override
	public void OnBrocastMember(long ulMeetingID, long uMemberid, long uState) {

	}

	@Override
	public void OnFirstBrocastSelect() {

	}

	@Override
	public void OnUpdateUserStatus(long ulMeetingID, long ulUserID, long ucStatus) {

	}

	@Override
	public void OnUpdateUserStatus(long ulUserID, long ucStatus) {

	}

	@Override
	public void OnModifyUserInfo(int ret) {

	}

	@Override
	public void UpdateUserMeetingInfo(long ulUserID, long ulMeetingID, long ulState, long ulMeetingType) {

	}

	@Override
	public void OnMemberVideoChannelPossessed(long ulMemberID, int nBrocasType, int nTotalFree) {

	}

	@Override
	public void OnGetDesUserInfo(Object pUserInfo, int ret) {

	}

	@Override
	public void OnSetRemarkName(int ret) {

	}

}
