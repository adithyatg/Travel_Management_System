ALTER TABLE person ADD COLUMN is_admin BOOLEAN DEFAULT FALSE;

CREATE OR REPLACE FUNCTION insert_into_users()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.is_admin = FALSE THEN
        INSERT INTO users (user_id, password) VALUES (NEW.user_id, NEW.password);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_insert_into_users
AFTER INSERT ON person
FOR EACH ROW EXECUTE FUNCTION insert_into_users();
