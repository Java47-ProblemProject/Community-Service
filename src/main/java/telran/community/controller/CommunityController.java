package telran.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.community.dto.*;
import telran.community.service.CommunityService;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/community")
@CrossOrigin(origins = "http://127.0.0.1:5173/", allowedHeaders = "*")
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

    @GetMapping("/getcommunities/{communityId}")
    public CommunityDto getCommunityById(@PathVariable String communityId) {
        return communityService.getCommunityById(communityId);
    }

    @GetMapping("/getcommunities")
    public Set<CommunityDto> getAllCommunities() {
        return communityService.getAllCommunities();
    }

    @GetMapping("/getcommunitiesnames")
    public Set<String> getAllCommunitiesNames() {
        return communityService.getAllCommunitiesNames();
    }
}
