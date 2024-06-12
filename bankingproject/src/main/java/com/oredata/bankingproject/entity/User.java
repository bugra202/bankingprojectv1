package com.oredata.bankingproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(name = "USERS")
@Entity
public class User extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 200,nullable = false)
    private String username;

    @Column(unique = true, length = 200, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //The method “getAuthorities()” returns the user’s roles list; it is helpful to manage permissions.
        //We return an empty list because we will not cover role-based access control.
        return List.of();
    }

    //isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired() ve isEnabled() yönteminin “true” döndürdüğünden emin olun;
    //aksi takdirde kimlik doğrulama başarısız olur. Bu yöntemlerin mantığını ihtiyaçlarınıza uyacak şekilde özelleştirebilirsiniz.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        //The method “getUsername()” returns the email address because it is unique information about the user.
        return email;
    }
    @Override
    public Long getId() {
        // UUID'yi Long'a dönüştürmek mantıklı değil, bu nedenle BaseEntity'deki getId() metodunu farklı bir şekilde yönetmelisiniz
        return null; // veya uygun bir değer döndürün
    }
}