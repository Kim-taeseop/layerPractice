package practice.layerPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.layerPractice.entity.HandEntity;
import practice.layerPractice.repository.HandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HandService {

    private final HandRepository handRepository;

    @Autowired
    public HandService(HandRepository handRepository){
        this.handRepository = handRepository;
    }

    // 회원가입
    public Long join(HandEntity handEntity){
        // 중복X
        validateDuplicate(handEntity);

        handRepository.save(handEntity);
        return handEntity.getId();
    }

    private void validateDuplicate(HandEntity handEntity) {
        handRepository.findById(handEntity.getId())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 id입니다.");
                        });
    }

    // 전체 조회
    public List<HandEntity> findHand() {
        return handRepository.findAll();
    }

    // 하나 조회
    public Optional<HandEntity> findOne(Long handId) {
        return handRepository.findById(handId);
    }



}
