package telran.community.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import telran.community.configuration.KafkaConsumer;
import telran.community.dao.CommunityRepository;
import telran.community.dto.*;
import telran.community.dto.exceptions.NoSuchCommunityException;
import telran.community.model.Community;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
    final CommunityRepository communityRepository;
    final KafkaConsumer kafkaConsumer;
    final ModelMapper modelMapper;

    @Override
    public CommunityDto addCommunity(CreateCommunityDto newCommunity) {
        Community community = modelMapper.map(newCommunity, Community.class);
        communityRepository.save(community);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    public CommunityDto editName(String communityId, NameDto newName) {
        Community community = communityRepository.findById(communityId).orElseThrow(NoSuchCommunityException::new);
        community.setName(newName.getName());
        communityRepository.save(community);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    public CommunityDto editDescription(String communityId, DescriptionDto newDescription) {
        Community community = communityRepository.findById(communityId).orElseThrow(NoSuchCommunityException::new);
        community.setDescription(newDescription.getDescription());
        communityRepository.save(community);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    public CommunityDto editSubCommunities(String communityId, SubCommunitiesDto newSubCommunities) {
        Community community = communityRepository.findById(communityId).orElseThrow(NoSuchCommunityException::new);
        community.addSubCommunities(newSubCommunities.getSubCommunities());
        communityRepository.save(community);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    public CommunityDto deleteCommunity(String communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow(NoSuchCommunityException::new);
        communityRepository.deleteById(communityId);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    public CommunityDto getCommunityById(String communityId) {
        return communityRepository.findById(communityId).map(e -> modelMapper.map(e, CommunityDto.class)).orElseThrow(NoSuchCommunityException::new);
    }
}
