package com.hariharnautiyal.velocity.h01.models

data class PendingAuthData(
    val uuid: String,
    val ip: String,
    val timestamp: String
)

data class SessionData(
    val createdAt: String,
    val expiresAt: String,
    val ip: String,
)

data class WebAuthRequest(
    val username: String,
    val ip: String,
    val authProvider: String,
    val providerId: String,
    val email: String?,
    val providerUsername: String? = null,
)

enum class LoginResult {
    SUCCESS,
    NEEDS_WEB_AUTH,
    ACCOUNT_IN_USE,
    AUTH_PENDING,
    ERROR
}

data class HealthStatus(
    val status: String,
    val timestamp: Long,
    val server: String,
    val players: Int,
    val servers: Int,
    val testMode: Boolean = false
)

data class AuthValidationResult(
    val success: Boolean,
    val error: String? = null,
    val accountStatus: String? = null, // "new", "existing", "linked",
)


data class ProviderCheckRequest(
    val provider: String,
    val providerId: String
)


data class CreateSessionResponse(
    val success: Boolean = false,
    val accountStatus: String,
    val error: String? = null,
)

data class CheckSessionResponse(
    val linked: Boolean = false,
    val minecraftUsername: String? = null,
    val error: String? = null,
)
enum class RemoveFriendResult {
    SUCCESS,
    PLAYER_NOT_FOUND,
    NOT_FRIEND,
    FAILED_TO_REMOVE,
    ERROR
}

enum class InviteFriendResult {
    SUCCESS,
    PLAYER_NOT_FOUND,
    ALREADY_FRIEND,
    FAILED_TO_INVITE, // Use this for "already sent request" or "they already sent you one"
    SELF_INVITE,
    BLOCKED, // New: Target player has invites blocked
    ERROR // Use this for actual system/Redis errors during invite registration
}

enum class AcceptFriendRequest {
    SUCCESS,
    PLAYER_NOT_FOUND,
    NOT_REQUESTED,
    FAILED_TO_ACCEPT,
    SELF_INVITE,
    ERROR
}

enum class DeclineFriendRequest {
    SUCCESS,
    SELF_INVITE,
    PLAYER_NOT_FOUND,
    NOT_REQUESTED,
    FAILED_TO_DECLINE,
    ERROR
}

enum class CreateTeamResponse {
    SUCCESS,
    ALREADY_REGISTERED_TEAM_NAME,
    ALREADY_REGISTERED_TEAM_COLOR,
    INVALID_NAME,
    PLAYER_NOT_FOUND,
    ERROR,
    ALREADY_IN_TEAM,
    INVALID_COLOR_FORMAT
}

enum class InviteToTeamResponse {
    SUCCESS,
    ALREADY_INVITED_BY_ANOTHER_TEAM,
    NOT_LEADER,
    PLAYER_NOT_FOUND,
    FAILED_TO_INVITE,
    ERROR,
    ALREADY_IN_TEAM,
    TEAM_FULL,
    BANNED,
    PLAYER_BANNED
}

enum class AcceptTeamInviteResponse {
    SUCCESS,
    PLAYER_NOT_FOUND,
    NOT_INVITED,
    ALREADY_IN_TEAM,
    FAILED_TO_ACCEPT,
    ERROR,
    TEAM_NOT_FOUND,
    TEAM_FULL,
}

enum class DeclineTeamInviteResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_INVITED, ERROR
}

enum class TeamRequestResponse {
    SUCCESS, PLAYER_NOT_FOUND, TEAM_NOT_FOUND, INVITE_BLOCKED, ALREADY_REQUESTED, ALREADY_MEMBER, ERROR, ALREADY_IN_TEAM, BANNED, TEAM_FULL, REQUEST_BLOCKED, PLAYER_BANNED
}

enum class HandleTeamRequestResponse {
    SUCCESS, TEAM_FULL, PLAYER_NOT_FOUND, NOT_LEADER, NO_REQUEST_FOUND, ERROR, TEAM_NOT_FOUND
}

enum class RemoveMemberResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_LEADER, MEMBER_NOT_FOUND, CANNOT_REMOVE_LEADER, ERROR
}

enum class LeaveTeamResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_IN_TEAM, LEADER_CANNOT_LEAVE, ERROR
}

enum class DeleteTeamResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_LEADER, TEAM_NOT_FOUND, ERROR
}

sealed class FriendInfoResponse {
    data class Success(val data: FriendInfoData) : FriendInfoResponse()
    object PlayerNotFound : FriendInfoResponse()
    object NotFriend : FriendInfoResponse()
    object Error : FriendInfoResponse()
}

data class FriendInfoData(
    val username: String,
    val teamName: String? = null,
    val teamColor: String? = null,
)

enum class BlockFriendResponse {
    SUCCESS, PLAYER_NOT_FOUND, ALREADY_BLOCKED, ERROR
}

enum class UnBlockFriendResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_BLOCKED, ERROR
}

enum class BanPlayerResponse {
    SUCCESS, PLAYER_NOT_FOUND, ALREADY_BANNED, ERROR, NOT_LEADER, CANNOT_BAN_LEADER, NOT_IN_TEAM
}

enum class UnbanPlayerResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_BANNED, ERROR, NOT_LEADER, CANNOT_BAN_LEADER, NOT_IN_TEAM
}

enum class TransferLeadershipResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_LEADER, ERROR, TEAM_NOT_FOUND, MEMBER_NOT_FOUND
}

enum class ChangeTeamColorResponse {
    SUCCESS, PLAYER_NOT_FOUND, COLOR_ALREADY_TAKEN, TEAM_NOT_FOUND, NOT_LEADER, ERROR, INVALID_COLOR_FORMAT, INVALID_TEAM_NAME
}

enum class ChangeTeamOpenResponse {
    SUCCESS, PLAYER_NOT_FOUND, TEAM_NOT_FOUND, NOT_LEADER, ERROR, INVALID_TEAM_NAME
}

enum class ChangeTeamRequestBlockResponse {
    SUCCESS, PLAYER_NOT_FOUND, TEAM_NOT_FOUND, NOT_LEADER, ERROR, INVALID_TEAM_NAME
}

sealed class GetBalanceResponse {
    data class Success(val balance: Long) : GetBalanceResponse()
    object PlayerNotFound : GetBalanceResponse()
    object Error : GetBalanceResponse()
}

enum class TransferBalanceResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_ENOUGH_FUNDS, ERROR
}

enum class BuyPrefixResponse {
    SUCCESS, PLAYER_NOT_FOUND, ALREADY_PURCHASED, ERROR, NOT_ENOUGH_FUNDS, PREFIX_NOT_FOUND
}

enum class EquipPrefixResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_PURCHASED, ERROR, PREFIX_NOT_FOUND
}

enum class UnequipPrefixResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_PURCHASED, ERROR, PREFIX_NOT_FOUND
}

enum class BuyVaultResponse {
    SUCCESS, PLAYER_NOT_FOUND, NOT_ENOUGH_FUNDS, ERROR
}

enum class RedeemCodeResponse {
    SUCCESS, PLAYER_NOT_FOUND, ALREADY_REDEEMED, ERROR, INVALID_CODE
}