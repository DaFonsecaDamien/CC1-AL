package infrastructure;

import domain.Membership;
import domain.MembershipId;
import kernel.Repository;

public interface MembershipRepository extends Repository<MembershipId, Membership> {
    @Override
    void add(Membership entity);

    @Override
    void delete(MembershipId id);
}
