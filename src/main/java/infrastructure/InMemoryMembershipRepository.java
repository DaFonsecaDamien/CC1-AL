package infrastructure;

import domain.Membership;
import domain.MembershipId;
import kernel.NoSuchEntityException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMembershipRepository implements MembershipRepository{

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<MembershipId, Membership> data = new ConcurrentHashMap<>();

    @Override
    public void add(Membership entity) {
        data.put(entity.getId(), entity);
    }

    @Override
    public void delete(MembershipId id) {

    }

    @Override
    public Membership findById(MembershipId id) throws NoSuchEntityException {
        final Membership membership = data.get(id);
        if(membership == null){
            throw NoSuchEntityException.withId(id);
        }
        return membership;
    }

    @Override
    public MembershipId nextIdentity() {
        return new MembershipId(counter.incrementAndGet());
    }
}

