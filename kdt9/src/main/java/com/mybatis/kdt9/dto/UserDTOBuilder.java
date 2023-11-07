package com.mybatis.kdt9.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTOBuilder {
    // @NoArgsConstructor : 기본 생성자를 만들어주는데, 필드가 없다.
    // @AllArgsConstructor : 모든 필드값이 포함된 생성자를 만들어주는 친구
    private final int id;
    private final String name;

    public static class Builder {
        private int id;
        private String name;
        public Builder id(int id) {
            this.id = id;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public UserDTOBuilder build() {
            return new UserDTOBuilder(id, name);
        }
    }
    public static Builder builder() {
        return new Builder();
    }
}
