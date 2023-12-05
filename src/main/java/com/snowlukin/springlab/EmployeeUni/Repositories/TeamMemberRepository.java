package com.snowlukin.springlab.EmployeeUni.Repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.snowlukin.springlab.EmployeeUni.Models.TeamMember;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamMemberRepository {
    private final String filePath = "src/main/java/com/snowlukin/springlab/EmployeeUni/Resources/database.json";
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public List<TeamMember> getAll() throws IOException {
        List<TeamMember> teamMembers = new ArrayList<>();
        teamMembers = mapper.readValue(new File(filePath), new TypeReference<List<TeamMember>>() {});
        return teamMembers;
    }

    public Optional<TeamMember> getById(long id) throws IOException {
        List<TeamMember> teamMembers = getAll();
        return teamMembers.stream().filter(teamMember -> teamMember.getId() == id).findFirst();
    }

    public TeamMember create(TeamMember member) throws IOException {
        List<TeamMember> teamMembers = getAll();

        // Finding the highest current id and adding 1
        long nextId = teamMembers.stream().mapToLong(TeamMember::getId).max().orElse(-1) + 1;
        member.setId(nextId);

        teamMembers.add(member);
        mapper.writeValue(new File(filePath), teamMembers);
        return member;
    }

    public void deleteAll() throws IOException {
        mapper.writeValue(new File(filePath), new ArrayList<TeamMember>());
    }

    public void deleteById(long id) throws IOException {
        List<TeamMember> teamMembers = getAll();
        teamMembers.removeIf(teamMember -> teamMember.getId() == id);
        mapper.writeValue(new File(filePath), teamMembers);
    }

    public TeamMember update(TeamMember member) throws IOException {
        List<TeamMember> teamMembers = getAll();
        teamMembers.removeIf(member1 -> member1.getId() == member.getId());
        teamMembers.add(member);
        mapper.writeValue(new File(filePath), teamMembers);
        return member;
    }
}
