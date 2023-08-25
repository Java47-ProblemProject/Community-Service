package telran.community.dto.accounting;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.Set;

@ToString
@Getter
public class ProfileDto {
    protected String username;
    protected String email;
    protected String educationLevel;
    protected Set<String> communities;
    protected LocationDto location;
    protected String password;
    protected Set<String> roles;
    protected String avatar;
    protected StatsDto stats;
    protected Map<String, ActivityDto> activities;
    protected Double wallet;
}