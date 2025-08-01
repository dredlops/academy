package com.ctw.workstation.dto;

import java.time.LocalDateTime;

public record TeamCreateRequestDTO (String name,
                                    String product,
                                    String defaultLocation,
                                    LocalDateTime createdAt,
                                    LocalDateTime modifiedAt){}
