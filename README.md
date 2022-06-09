# keycloak-adaptors-feacher
repository for connection to keycloak IDP and manage permission with and without policy enforcement   


The ROPC (Resource Owner Password Credentials) flow is no longer supported by the oauth2 api
Need to target the AuthorizationCode flow which requires the implementation of an IdentityProvider.

**_Recommended solution:_** Keyclock that implements openidconnect + oauth 2.1

**Disadvantages of using ROPC**

1. ROPC is impersonation, not authentication
2. ROPC exposes end-user credentials to applications
3. User cannot consent
4. ROPC encourages phishing
5. ROPC does not support multi-factor authentication (MFA)
6. ROPC does not support single sign-on (SSO, OpenID Connect only)
7. ROPC cannot support federation
8. ROPC is not secure for mobile apps and single page apps
9. ROPC has been deprecated by the OAuth Working Group

![](/home/kolsi-omar/Pictures/Authorization Server Support.png)

**Why keylock?**

* **Support for multiple protocols:** Keycloak supports three different protocols, namely - OpenID Connect, OAuth 2.0 and SAML 2.0.

* **SSO:** Keycloak fully supports single sign-on and single sign-out for the duration of a session.

* **External Identity Source Synchronization:** By default, it supports LDAP and Active Directory, but you can create custom extensions for any user database using the Keycloak storage API User.

* **Identity Brokering:** Keycloak can also work as a proxy between your users and certain external identity providers. Their list can be edited from the Keycloak admin panel.

* **Social Identity Providers:** Keycloak allows us to use social identity providers. It has built-in Google, Twitter, Facebook, Stack Overflow support

* **Pages Customization:** Keycloak allows you to customize all the pages displayed by it for your users.

**Now let's get to work...**

**Step 1 :** 

**to start the keycloak instance lunch the keycloak-docker-compose.yml file by the following command :**

1. [ ] docker-compose -f keycloak-docker-compose.yml up




