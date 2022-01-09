package fr.esgi.al.use_cases.membership.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("all")
@XmlRootElement
public class MembershipsResponse {
    public final List<MembershipResponse> members;

    public MembershipsResponse(List<MembershipResponse> members) {
        this.members = members;
    }
}
