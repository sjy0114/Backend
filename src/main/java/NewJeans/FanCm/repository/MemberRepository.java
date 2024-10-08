package NewJeans.FanCm.repository;

import NewJeans.FanCm.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    @Transactional
    public void save(Member member){
        em.persist(member);
    }

    //ID 조회
    public List<Member> findByID(String Id){
        return em.createQuery("select u from Member u where u.id = :Id", Member.class)
                .setParameter("Id", Id)
                .getResultList();
    }

    //nickname 조회
    public List<Member> findByNickname(String nickname){
        return em.createQuery("select u from Member u where u.nickName = :nickname", Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }

}
