package telran.community.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import telran.community.kafka.KafkaConsumer;
import telran.community.dao.CommunityRepository;
import telran.community.dto.*;
import telran.community.dto.exceptions.CommunityExistsException;
import telran.community.dto.exceptions.NoSuchCommunityException;
import telran.community.model.CommunitiesToFill;
import telran.community.model.Community;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService, CommandLineRunner {
    final CommunityRepository communityRepository;
    final KafkaConsumer kafkaConsumer;
    final ModelMapper modelMapper;
    final CommunitiesToFill communitiesToFill;

    @Override
    @Transactional
    public CommunityDto addCommunity(CreateCommunityDto newCommunity) {
        if (communityRepository.existsById(newCommunity.getName())) {
            throw new CommunityExistsException();
        }
        Community community = modelMapper.map(newCommunity, Community.class);
        communityRepository.save(community);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    @Transactional
    public CommunityDto editName(String communityId, NameDto newName) {
        if (communityRepository.existsById(newName.getName())) {
            throw new CommunityExistsException();
        }
        Community community = communityRepository.findById(communityId).orElseThrow(NoSuchCommunityException::new);
        community.setName(newName.getName());
        communityRepository.save(community);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    @Transactional
    public CommunityDto editDescription(String communityId, DescriptionDto newDescription) {
        Community community = communityRepository.findById(communityId).orElseThrow(NoSuchCommunityException::new);
        community.setDescription(newDescription.getDescription());
        communityRepository.save(community);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    @Transactional
    public CommunityDto editSubCommunities(String communityId, SubCommunitiesDto newSubCommunities) {
        if (newSubCommunities.getSubCommunities().stream().anyMatch(communityRepository::existsById)) {
            throw new CommunityExistsException();
        }
        Community community = communityRepository.findById(communityId).orElseThrow(NoSuchCommunityException::new);
        community.addSubCommunities(newSubCommunities.getSubCommunities());
        communityRepository.save(community);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    @Transactional
    public CommunityDto deleteCommunity(String communityId) {
        Community community = communityRepository.findById(communityId).orElseThrow(NoSuchCommunityException::new);
        communityRepository.deleteById(communityId);
        return modelMapper.map(community, CommunityDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public CommunityDto getCommunityById(String communityId) {
        return communityRepository.findById(communityId).map(e -> modelMapper.map(e, CommunityDto.class)).orElseThrow(NoSuchCommunityException::new);
    }

    @Override
    public Set<CommunityDto> getAllCommunities() {
        return communityRepository.findAll().stream().map(e -> modelMapper.map(e, CommunityDto.class)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Set<String> getAllCommunitiesNames() {
        return communityRepository.findAll().stream().map(Community::getName).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public void run(String... args) throws Exception {
        //communitiesToFill.fillAllCommunities();
    }
}
