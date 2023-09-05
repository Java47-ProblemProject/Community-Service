package telran.community.service;

import telran.community.dto.*;

import java.util.Set;

public interface CommunityService {
    CommunityDto addCommunity(CreateCommunityDto newCommunity);
    CommunityDto editName(String communityId, NameDto newName);
    CommunityDto editDescription(String communityId, DescriptionDto newDescription);
    CommunityDto editSubCommunities(String communityId, SubCommunitiesDto newSubCommunities);
    CommunityDto deleteCommunity(String communityId);
    CommunityDto getCommunityById(String name);
    Set<CommunityDto> getAllCommunities();
    Set<String> getAllCommunitiesNames();
}
