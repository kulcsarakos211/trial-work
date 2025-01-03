package com.example.trialworkbackend.repositories;

import com.example.trialworkbackend.entities.Membership;
import com.example.trialworkbackend.entities.MembershipId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends CrudRepository<Membership, MembershipId> {
}
