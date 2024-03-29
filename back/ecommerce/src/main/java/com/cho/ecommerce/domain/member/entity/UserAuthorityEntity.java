package com.cho.ecommerce.domain.member.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MEMBER_AUTHORITY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserAuthorityEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;  // Add this line
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_authority_seq")
//    @SequenceGenerator(
//        name = "user_authority_seq",
//        sequenceName = "USER_AUTHORITY_SEQ",
//        allocationSize = 1000
//    )
    @Column(name = "USER_AUTHORITY_ID")
    private Long userAuthorityId;
    
    //    @NotNull(message = "User is required")
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private UserEntity userEntity;
    
    //    @NotNull(message = "Authority is required")
    @ManyToOne
    @JoinColumn(name = "AUTHORITY_ID")
    private AuthorityEntity authorityEntity;
    
    public AuthorityEntity getAuthorityEntity() {
        return authorityEntity;
    }
    
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    
    public void setAuthorityEntity(AuthorityEntity authorityEntity) {
        this.authorityEntity = authorityEntity;
    }
    
    @Override
    public String toString() {
        return "UserAuthority{" +
            "id=" + userAuthorityId +
            ", authority=" + authorityEntity +
            '}';
    }
    
    // Implementing hashCode() and equals() without referencing user to avoid recursion
    @Override
    public int hashCode() {
        return Objects.hash(userAuthorityId, authorityEntity);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserAuthorityEntity that = (UserAuthorityEntity) obj;
        return Objects.equals(userAuthorityId, that.userAuthorityId) &&
            Objects.equals(authorityEntity, that.authorityEntity);
    }
}
