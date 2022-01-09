package fr.esgi.al.use_cases.membership.infrastructure;

import fr.esgi.al.kernel.NoSuchEntityException;
import fr.esgi.al.use_cases.membership.application.MembershipDTO;
import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipID;
import fr.esgi.al.use_cases.membership.domain.MembershipRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryMembershipRepository implements MembershipRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<MembershipID, Membership> data = new ConcurrentHashMap<>();

    @Override
    public void add(Membership membership) {
        data.put(membership.getId(), membership);
    }

    @Override
    public void delete(MembershipID id) {
        data.remove(id);
    }

    @Override
    public Membership findById(MembershipID id) throws NoSuchEntityException {
        final Membership membership = data.get(id);
        if (membership == null) {
            throw NoSuchEntityException.withId(id);
        }
        return membership;
    }

    @Override
    public MembershipID nextIdentity() {
        return new MembershipID(counter.incrementAndGet());
    }

    @Override
    public List<Membership> findAll() {
        return List.copyOf(data.values());
    }
}

