package com.snowlukin.springlab.EmployeeUni.Controllers;

import com.snowlukin.springlab.EmployeeUni.Models.TeamMember;
import com.snowlukin.springlab.EmployeeUni.Repositories.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/team-members")
public class TeamMemberController {
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @GetMapping
    public ResponseEntity<List<TeamMember>> getAll() {
        try {
            return ResponseEntity.ok(teamMemberRepository.getAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMember> getById(@PathVariable long id) {
        try {
            Optional<TeamMember> teamMember = teamMemberRepository.getById(id);
            return teamMember.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<TeamMember> create(@RequestBody TeamMember teamMember) {
        try {
            return ResponseEntity.ok(teamMemberRepository.create(teamMember));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamMember> update(@PathVariable long id, @RequestBody TeamMember teamMember) {
        try {
            Optional<TeamMember> teamMemberOptional = teamMemberRepository.getById(id);
            if (teamMemberOptional.isPresent()) {
                teamMember.setId(id);
                return ResponseEntity.ok(teamMemberRepository.update(teamMember));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/role/{id}")
    public ResponseEntity<TeamMember> updateRole(@PathVariable long id, @RequestBody String newRole) {
        try {
            Optional<TeamMember> teamMemberOptional = teamMemberRepository.getById(id);
            if (teamMemberOptional.isPresent()) {
                TeamMember teamMember = teamMemberOptional.get();
                teamMember.setRole(newRole);
                return ResponseEntity.ok(teamMemberRepository.update(teamMember));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/spec/{id}")
    public ResponseEntity<TeamMember> updateSpec(@PathVariable long id, @RequestBody String newSpec) {
        try {
            Optional<TeamMember> teamMemberOptional = teamMemberRepository.getById(id);
            if (teamMemberOptional.isPresent()) {
                TeamMember teamMember = teamMemberOptional.get();
                teamMember.setSpecialization(newSpec);
                return ResponseEntity.ok(teamMemberRepository.update(teamMember));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/hiring/{id}")
    public ResponseEntity<TeamMember> updateHiringDate(@PathVariable long id, @RequestBody String hiringDate) {
        try {
            Optional<TeamMember> teamMemberOptional = teamMemberRepository.getById(id);
            if (teamMemberOptional.isPresent()) {
                TeamMember teamMember = teamMemberOptional.get();
                teamMember.setHiringDate(LocalDate.parse(hiringDate));
                return ResponseEntity.ok(teamMemberRepository.update(teamMember));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        try {
            Optional<TeamMember> teamMember = teamMemberRepository.getById(id);
            if (teamMember.isPresent()) {
                teamMemberRepository.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        try {
            teamMemberRepository.deleteAll();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
