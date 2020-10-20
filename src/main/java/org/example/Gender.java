package org.example;

public enum Gender {
        male('M') {
                @Override
                public String toString() {
                        return "M";
                }
        },
        female('F') {
                @Override
                public String toString() {
                        return "F";
                }
        };

        public final Character gender;

        Gender(Character gender) {
                this.gender = Character.toUpperCase(gender);
        }

        public Character getGender() {
                return gender;
        }
}
