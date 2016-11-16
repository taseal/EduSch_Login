package com.seal.www.edusch_login.core;


public interface IC2SNotify {

	void OnSearchFriendEnd();

	void OnRawMessage(long msgid, long param, long context);

	/*
	 * 建立连接
	 */
	void OnConnected();

	void OnDisconnected(int error);

	/*
	 * 断开连接之后会重新连
	 */
	void OnReconnect(long ulError);

	void OnMemberLogin(short usErrCode, long ulMemberID);

	/**
	 * 删除会议 usErrCode == 21成功，其它失败
	 * 
	 * @param usErrCode
	 * @param ulMeetingID
	 */
	void OnDeleteMeetingRoom(short usErrCode, long ulMeetingID);

	/**
	 * 删除会员
	 * 
	 * @param usErrCode
	 * @param ulMeetingID
	 * @param ulMemberID
	 */
	void OnDeleteMeetingMember(short usErrCode, long ulMeetingID, long ulMemberID);

	void OnGetMeetingBaseItem(Object oMeetingBase);

	void OnGetMeetingMemberBaseItem(Object oMemberBaseItem);

	void OnApplyJoinMeeting(short usErrCode, long ulMeetingID, long ulMemberID, String strNickName);

	/**
	 * 接收加入会议时回调
	 * 
	 * @param ulMeetingID
	 *            会议ID
	 * @param ulMemberID
	 *            成员ID
	 */
	void OnAcceptJoinMeeting(long ulMeetingID, long ulMemberID);

	/**
	 * 拒绝加入会议时回调
	 * 
	 * @param ulMeetingID
	 *            会议ID
	 * @param ulMemberID
	 *            成员ID
	 * @param ulError
	 *            拒绝的方式 0--用户拒绝，1---等待超时拒绝，2---用户已在房间拒绝
	 */
	void OnRejectJoinMeeting(long ulMeetingID, long ulMemberID, long ulError);

	void OnSelfJoinMeetingRoom(short usErrCode, long ulMeetingID);

	void OnOtherJoinMeetingRoom(short usErrCode, long uMemberid, long ulMeetingID);

	void Meeting_InviteUserJoinMeeting(long ulMeetingID, long ulUserID);

	void OnIEMMeetingInvite(long ulMeetingID, long ulUserID, long mType, String strNickName);

	void OnReceivedMeetingData(long uMemberid, Object rCmdPacket);

	void OnShowMessage(String str);

	void OnExitMeeting();

	void UpdateMeetingMemberStatus(long ulMeetingID, long ulMemberID, char ucStatus);
	
	/**
	 * 更新房间状态
	 * @param ulMeetingID
	 * @param ucStatus!=2说明就是关闭房间
	 */
	void UpdateMeetingStatus(long ulMeetingID, char ucStatus);

	void OnGetUserInfo(Object userInfo, int nDomainID);
	
	void OnDepartItem(Object departItem);

	void OnDepartMemberItem(Object departMemberItem);

	/**
	 * 获取域内的联系人
	 * 
	 * @param userItem
	 */
	void OnUserListItem(Object userItem);

	/**
	 * 获取域内的联系人 完成
	 */
	void OnFetchAllUserEnd();

	/**
	 * 获取单个联系人
	 * 
	 * @param userItem
	 */
	void OnFriendItem(Object userItem);

	/**
	 * 获取联系人完成
	 */
	void OnFetchAllFriendEnd();

	void OnSearchFriend(Object userItem);

	void OnAddFriend(Object userItem);

	void OnDeleteFriend(long ulUserID);

	void OnGroupItem(Object groupItem);

	void OnAddGroup(Object groupItem);

	void OnDeleteGroup(long ulGroupID);

	void OnGroupMemberItem(Object GroupMemberItem);

	void OnAddGroupMember(Object groupMemberItem);

	void OnDeleteGroupMember(long ulUserID, long ulGroupID);

	// 获取所有分组完成
	void OnFetchAllGroupMemberEnd(String type);

	/**
	 * 获取单个域名
	 * 
	 * @param strDomain
	 */
	void OnDomainItem(String strDomain);

	/**
	 * 获取域名完成
	 */
	void OnFetchDomainEnd();

	// Ret（REGISTER_SYSTEM_SUCCESS=7,REGISTER_SYSTEM_ERROR=8,REGISTER_SYSTEM_ALREADY_EXIST=9
	void OnRegisiterUser(int ret);

	void OnModifyGroup(Object groupinfos);

	void OnMobileNOCheck(Object userInfo);

	/**
	 * 等待房间创建返回消息
	 * 
	 * @param meetingBaseItem
	 */
	void OnRoomMeetingCreateOver(Object meetingBaseItem);

	/**
	 * 返回会议房间成员
	 * 
	 * @param ulMemberID
	 * @param strmemberName
	 * @param nTheLastMember
	 */
	void OnMeetingMemberInfo(long ulMeetingID, long ulMemberID, String strmemberName, int nTheLastMember);

	/**
	 * 更新房间信息回调 sErrCode = 8 SUCCESS, = 9 ERROR, = 10 ROOM_NOT_EXIST, = 11
	 * NOT_ROOM_CREATOR
	 * 
	 * @param usErrCode
	 * @param ulMemberID
	 * @param meetingBaseItem
	 */
	void OnModifyMeeting(int usErrCode, long ulMemberID, Object meetingBaseItem);

	// 能加入的会议
	void OnHeldMeetingBaseItem(Object meetingBaseItem);

	void OnKickOutMeetingMember(long ulMeetingID, long ulMemberID);

	void OnEndMeeting(long ulMeetingID);

	/**
	 * 返回 房间信息(获取房间信息)
	 * 
	 * @param pMeetingBaseItem
	 * @param ulIntervalTime
	 */
	void OnMeetingBaseItem(Object pMeetingBaseItem, long ulIntervalTime);

	/**
	 * 返回 房间中成员信息（获取房间里面有哪些成员）
	 * 
	 * @param pMemberBaseItem
	 */
	void OnMemberBaseItem(Object pMemberBaseItem);

	void OnAddMeetingMember(long ulErrCode, long ulMeetingID, long ulMemberID);

	/**
	 * 返回当前广播人员状态,客户端收到，根据uBrocastState判断房主传的是视频还是音频来决定要不要设置surface
	 * 
	 * @param ulMeetingID
	 *            房间ID
	 * @param uMemberid
	 *            成员id
	 * @param uState
	 *            广播状态(BROCAST_AUDIO_VIDEO =
	 *            0,BROCAST_VIDEO=1,BROCAST_AUDIO=2,BROCAST_NONE=3)
	 */
	void OnBrocastMember(long ulMeetingID, long uMemberid, long uState);

	/*************************************************
	 * 函数名：OnFirstBrocastSelect 参数: 日期:2015/7/7 返回值:void 描述：第一次创建房间是否需要广播的处理消息
	 **************************************************/
	void OnFirstBrocastSelect();

	/**
	 * 在 会议时/会议中 状态改变会调用此方法
	 * 
	 * @param ulMeetingID
	 *            会议ID 0 不在房间
	 * @param ulUserID
	 *            用户ID
	 * @param ucStatus
	 *            通话状态 0 用户离线 , 1 用户在线 , 2 在自己房间 ，3在别人的会议里，4无人接听(呼叫超时)
	 */
	void OnUpdateUserStatus(long ulMeetingID, long ulUserID, long ucStatus);

	/**
	 * 联系人状态更新 (在线/离线)
	 * 
	 * @param ulUserID
	 *            用户ID
	 * @param ucStatus
	 *            用户状态
	 */
	void OnUpdateUserStatus(long ulUserID, long ucStatus);

	/**
	 * 修改域名成功回调
	 */
	void OnModifyUserInfo(int ret);

	/**
	 *
	 * 不在房间/在房间
	 */
	void UpdateUserMeetingInfo(long ulUserID, long ulMeetingID, long ulState, long ulMeetingType);

	/**
	 * @Description 广播视频或者音视频时，通道被占用
	 * @param ulMemberID
	 *            要广播的人的id
	 * @param nBrocasType
	 *            广播类型
	 * @param nTotalFree
	 *            nTotalFree--广播空闲路数
	 */
	void OnMemberVideoChannelPossessed(long ulMemberID, int nBrocasType, int nTotalFree);

	/**
	 * 搜索完成的结果
	 * 
	 * @param pUserInfo
	 * @param ret
	 *            ret = 1 没有查询到好友 ， ret = 0 查询到好友
	 */
	void OnGetDesUserInfo(Object pUserInfo, int ret);

	/**
	 * 设备联系人备注回调
	 * 
	 * @param ret
	 *            :0(成功)，1（失败）
	 */
	void OnSetRemarkName(int ret);

	/*************************************************
	 * 函数名：OnCurNetState 参数:ulCurNetState--当前网络连接状态0--正在连接，1--已连接上 日期:2015/11/6
	 * 返回值:void 描述：检查当前网络连接状态
	 **************************************************/
	void OnCurNetState(long ulCurNetState);

	void OnSetHostMan(long ulMemberID, long ulMeetingID);

	void OnShowErrorMessage(long nErrorCode);

	/**
	 * 个人消息回调
	 * 
	 * @param messageBean
	 */
	void OnFetchBulletin(Object messageBean);

	/**
	 * 下面的是系统消息回调
	 * 
	 * @param ulSysMsgID
	 */
	void OnNewSysMsg(long ulSysMsgID);
	
	/**
	 * 拨打会议号 --〉CallMeetingNum
	 * @param meetingBaseItem
	 * @param strMeetingNum
	 * @param nRet = 0 success，=1 error
	 */
	void OnCallMeetingNum(Object meetingBaseItem, String strMeetingNum, int nRet);
}
