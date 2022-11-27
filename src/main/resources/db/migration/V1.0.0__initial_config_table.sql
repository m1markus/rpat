CREATE TABLE IF NOT EXISTS config
(
    application VARCHAR(256) NOT NULL,
    key VARCHAR(512) NOT NULL,
    value VARCHAR(262144),
    validFrom TIMESTAMP WITH TIME ZONE,
    validUntil TIMESTAMP WITH TIME ZONE,

    CONSTRAINT config_pkey PRIMARY KEY (application ASC, key ASC)
);

