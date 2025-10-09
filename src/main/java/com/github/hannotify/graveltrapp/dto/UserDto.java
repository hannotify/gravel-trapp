package com.github.hannotify.graveltrapp.dto;

import java.util.Set;

public record UserDto(String username, String password, Set<String> roles) {
}
