CREATE UNIQUE INDEX IF NOT EXISTS user_name_unique_idx
    ON users (username)
    WHERE deleted = false;