package com.seal.www.edusch_login.core;

public class ClientSessMgr {

	private static ClientSessMgr clientsessMgr;

	public static ClientSessMgr getInstance() {
		if (clientsessMgr == null) {
			clientsessMgr = new ClientSessMgr();
		}
		return clientsessMgr;
	}

	static {
		System.loadLibrary("lbs");
		/*System.loadLibrary("sqllite");
		System.loadLibrary("stlport_shared");
		System.loadLibrary("voiceprocesserd");
		System.loadLibrary("clientsess");*/
	}

	public static native int CSMCreateEMClient(Object _obj, Object ctx);

	public static native void CSMProcessRawMessage(long msgid, long param, long context);

	public static native boolean CSMConnect(int hMgr, String szRouteAddress, short usRouteport);

	public static native void CSMReleaseConnections(int hMgr);

	public static native void CSMLogin(int hMgr, String szUserID, String szPassword, String szDomain, String szVersion);

	public static native void CSMApplyJoinMeeting(int hMgr, long ulMeetingID, long ulMemberID, String strNickName);

	public native void CSMAcceptJoinMeeting(int hMgr, long ulMeetingID, long ulMemberID);

	/**
	 * 
	 * @author Seal
	 * @date 2016年11月7日
	 * @param ulMeetingID
	 * @param jstrMeetingNum
	 * 回调OnSelfJoinMeetingRoom
	 */
	public static native void CSMJoinMeetingRoom(long ulMeetingID, String jstrMeetingNum);

	public static native void CSMAcceptInvitation(int hMgr, long ulMeetingID, long ulMemberID);

	public static native void CSMRejectInvitation(int hMgr, long ulMeetingID, long ulMemberID, String strNickName);

	// 拒绝邀请 0--用户拒绝，1---等待超时拒绝，2---用户已在房间拒绝
	public static native void CSMRejectInvitation(int hMgr, long ulMeetingID, long ulMemberID, long ulRejectType);

	public static native void CSMReleaseModule(int hMgr);

	public native void CSMSendMeetingData(int hMgr, long ulMeetingID, Object cmdpacket);

	public static native void CSMJNITimer(int hMgr, int span);

	public static native void FetchDepartItemList(long ulDepartID);

	public static native void FetchDepartMemberItemList(long ulDepartID);

	/**
	 * 获取同一域名下用户，回调对应IC2SNotify OnUserListItem();
	 */
	public static native void CSMFetchAllUser();

	/**
	 * 获取联系人列表回调函数对应：OnFriendItem();
	 */
	public static native void CSMFetchAllFriend();

	// 搜索联系人 ulSearchType 0（模糊），1（在线） 回调对应：OnSearchFriend();
	public static native void CSMSearchFriend(long ulSearchType, String strName);

	// 添加联系人 回调对应:OnAddFriend();
	public static native void CSMAddFriend(long ulFriendID, String msg);

	// 删除联系人 回调对应:OnDeleteFriend();
	public static native void CSMDeleteFriend(long ulUserID);

	// 获取分组列表 回调对应：OnGroupItem(Object groupItem)
	public static native void CSMFetchAllGroup(byte type);

	// 添加组 回调对应：OnAddGroup(Object groupItem)
	public static native void CSMAddGroup(String strGroupName, byte type);

	// 删除组 回调对应：OnDeleteGroup(long ulGroupID)
	public static native void CSMDeleteGroup(long ulGroupID, byte type);

	// 获取所有分组成员 回调对应：OnGroupMemberItem(Object groupMemberItem);
	public static native void CSMFetchAllGroupMember(byte type);

	// 添加到分组 回调对应：OnAddGroupMember(Object groupMemberItem);
	public static native void CSMAddGroupMember(long ulUserID, long ulGroupID);

	// 从分组里删除 回调对应： OnDeleteGroupMember(long ulUserID);
	public static native void CSMDeleteGroupMember(long ulUserID, long ulGroupID);

	// 获取域列表 回调对应OnDomainItem(string strDomain);
	public static native void CSMFetchAllDomain(String szRouteAddress, short usRouteport);

	// 用户注册 回调对应OnRegisiterUser(int ret)
	public static native void CSMRegisiterUser(String szRouteAddress, short usRouteport, Object userinfo);

	// 修改組名 回调对应 OnModifyGroup(Object groupinfos)
	public static native void CSMModifyGroup(long ulGroupID, String strGroupName);

	/**
	 * 验证手机联系人是否注册 已经注册则 回调 OnMobileNOCheck(Object userInfo)
	 * 
	 * @param strMobileNO
	 */
	public static native void CSMMobileNOCheck(String strMobileNO);

	// 获取视频会议列表 回调对应 OnGetMeetingBaseItem(Object oMeetingBase)
	public static native void CSMMeetingGroups(long ulType);

	// 获取视频会议列表 回调对应 OnGetMeetingBaseItem(Object oMeetingBase)
	public static native void CSMMeetingGroups();

	// 向房间添加成员,ucMemberType : 0是null，1代表创建者，2代表申请加入的，3代表邀请加入的
	public static native void AddMeetingMember(long ulMeetingID, long ulMemberID, int ucMemberType);

	// 邀请当前在线成员
	public static native void InviteMemberToMeeting(long ulMeetingID, long ulMemberID);

	// 离开房间
	// 先将房间中的成员剔除
	public static native void KickOutMeetingMember(long ulMeetingID, long ulMemberID);

	// 然后调用离开房间接口
	public static native void ExitMeeting(long ulMeetingID);

	// 结束会议
	public static native void EndMeeting(long ulMeetingID);

	// 删除会议成员
	public static native void DeleteMeetingMember(long ulMeetingID, long ulMemberID);

	// 发起语音呼叫 2015-6-10 11:34:52
	public static native boolean CSMPutMsgAudioCall(long ulUserID);

	/**
	 * 接受对方语音呼叫
	 */
	public static native void CSMAcceptMsgRingAudioCall(long ulUserID);

	/**
	 * 拒绝对方语音呼叫
	 */
	public static native void CSMRejectMsgRingAudioCall(long ulUserID);

	/**
	 * 发起视频呼叫
	 */
	public static native boolean CSMPutMsgAVCall(long ulUserID);

	/**
	 * 接受对方视频呼叫
	 */
	public static native void CSMAcceptMsgRingAVCall(long ulUserID);

	/**
	 * 拒绝对方视频呼叫
	 */
	public static native void CSMRejectMsgRingAVCall(long ulUserID);

	/**
	 * 修改域
	 * 
	 * @param userinfo
	 */
	public static native void CSMModifyUserInfo(Object userinfo);

	/**
	 * logout
	 */
	public static native void CSMLogout();

	// 扫描二维码后搜索联系人
	public static native void CSMGetUserInfo(String szUserName);

	// add by LS 2015.5.19 创建房间
	// public static native void CreateRoomMetting(String strRoomName, long
	// nRoomType, long starttime);

	public static native void CreateRoomMetting(Object meetingBaseItem);

	/**
	 * 删除房间
	 * 
	 * @param ulMeetingID
	 */
	public static native void DeleteMeetingRoom(long ulMeetingID); // add by kh

	// 请求会议成员
	// 对应 void OnMeetingMemberInfo
	public static native void CSMGetMeetingMembersByMeetingID(long ulMeetingID);

	// 更新会议房间信息，
	// 对应 void OnModifyMeeting(int usErrCode,long ulMemberID,object
	// meetingBaseItem)
	public static native void CSMUpdataMeetingRoom(Object meetingBaseItem);

	/**
	 * 获取正在召开的房
	 * 对应回调：OnHeldMeetingBaseItem
	 * @param ulUserID
	 */
	public static native void CSMGetHeldMeeting(long ulUserID);

	/**
	 * 设备联系人备注 对应回调：IC2SNotify.OnSetRemarkName
	 * 
	 * @param ulUserID
	 *            用户ID
	 * @param strRemarkName
	 *            备注名称
	 */
	public static native void CSMSetRemarkName(long ulUserID, String strRemarkName);

	/**
	 * 设备视频编码质量
	 * 
	 * @param quality
	 *            =0 低品质 1高品质
	 */
	public static native void CSMSetTransferMode(int quality);

	/**
	 * 获取消息
	 * 
	 * @param ulUserID
	 */
	public static native void CSMGetBulletinMsg(long ulUserID);

	/**
	 * 接受添加
	 * 
	 * @param ulInvitatorID
	 * @param strMsg
	 */
	public static native void CSMAcceptFriend(long ulInvitatorID, String strMsg);

	/**
	 * 拒绝添加
	 * 
	 * @param ulInvitatorID
	 * @param strMsg
	 */
	public static native void CSMRejectFriend(long ulInvitatorID, String strMsg);

	/**
	 * 申请改域
	 * 
	 * @param strDomain
	 */
	public static native void CSMApplyJoinDomain(String strDomain);

	/**
	 * 拨打会议号-->void OnCallMeetingNum
	 * 
	 * @param jstrMeetingNum
	 */
	public static native void CallMeetingNum(String jstrMeetingNum);

}
