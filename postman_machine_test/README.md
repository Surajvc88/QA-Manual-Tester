# Postman API Testing - Machine Test

This project contains a Postman environment and collection to perform the machine test:
- Login (valid credentials)
- Login (invalid credentials)
- Add Customer (requires token from login)

## Files
- `MachineTest.postman_collection.json` - Postman collection (requests + tests)
- `MachineTest.postman_environment.json` - Environment with variables (baseUrl, userid, password, authToken)
- `README.md` - This file

## Setup
1. Install Postman.
2. Import the environment:
   - File -> Import -> Choose `MachineTest.postman_environment.json`
   - Make sure `baseUrl` is updated to the target base URL (e.g., https://staging.example.com)
3. Import the collection:
   - File -> Import -> Choose `MachineTest.postman_collection.json`
4. In Postman, select the imported environment.

## Usage
1. Run `Login - Valid Credentials` to obtain `authToken` automatically (test script stores it in environment).
2. Run `Add Customer` — it uses `{{authToken}}` in Authorization header.
3. Run `Login - Invalid Credentials` to validate negative behavior.

## Running from CLI
Install Newman:
```
npm install -g newman
```
Run collection:
```
newman run MachineTest.postman_collection.json -e MachineTest.postman_environment.json
```

## Notes & Tips
- Update `{{baseUrl}}` environment variable to the actual application base URL.
- If login response uses a different token field, update the test script to extract the correct field (e.g., `json.data.token`).
- If API paths differ, update request URLs accordingly.
- For secure storage of credentials in CI, use environment variables or secrets in your runner.

## How to upload to GitHub
1. Create a new repository on GitHub.
2. Initialize local git repo, add files, commit and push:
```bash
git init
git add .
git commit -m "Add Postman collection and environment for machine test"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```
3. Share the repository link.

## Deliverables to share
- Link to GitHub repo
- Postman collection JSON & environment JSON
- Newman command/output (optional)

