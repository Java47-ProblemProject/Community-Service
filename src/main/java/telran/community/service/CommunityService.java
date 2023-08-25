package telran.community.service;

import telran.community.dto.*;

public interface CommunityService {
    CommunityDto addCommunity(CreateCommunityDto newCommunity);
    CommunityDto editName(String communityId, NameDto newName);
    CommunityDto editDescription(String communityId, DescriptionDto newDescription);
    CommunityDto editSubCommunities(String communityId, SubCommunitiesDto newSubCommunities);
    CommunityDto deleteCommunity(String communityId);
    CommunityDto getCommunityById(String name);
}
