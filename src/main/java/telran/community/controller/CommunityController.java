package telran.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.community.dto.*;
import telran.community.service.CommunityService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/community")
public class CommunityController {
    final CommunityService communityService;

    @PostMapping("/addcommunity")
    public CommunityDto addCommunity(@RequestBody CreateCommunityDto newCommunity) {
        return communityService.addCommunity(newCommunity);
    }

    @PutMapping("/editname/{communityId}")
    public CommunityDto editName(@PathVariable String communityId, @RequestBody NameDto newName) {
        return communityService.editName(communityId, newName);
    }

    @PutMapping("/editdescription/{communityId}")
    public CommunityDto editDescription(@PathVariable String communityId, @RequestBody DescriptionDto newDescription) {
        return communityService.editDescription(communityId, newDescription);
    }

    @PutMapping("/addsubcommunities/{communityId}")
    public CommunityDto editSubCommunities(@PathVariable String communityId, @RequestBody SubCommunitiesDto newSubCommunities) {
        return communityService.editSubCommunities(communityId, newSubCommunities);
    }

    @DeleteMapping("/deletecommunity/{communityId}")
    public CommunityDto deleteCommunity(@PathVariable String communityId) {
        return communityService.deleteCommunity(communityId);
    }

    @GetMapping("/getcommunities")
    public CommunityDto getCommunityById(String communityId) {
        return communityService.getCommunityById(communityId);
    }
}
